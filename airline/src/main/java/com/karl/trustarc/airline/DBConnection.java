package com.karl.trustarc.airline;

import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class DBConnection {
	private static SessionFactory factory;
	private static List<Passenger> id = new ArrayList<>();
	protected static List<Flight> flights = new ArrayList<>();
	protected static List<Integer> reserve = new ArrayList<>();
	
	public DBConnection() {
	    try {
	        factory = new Configuration().
	                  configure().
	                  addPackage("com.karl.trustarc.airline").
	                  addAnnotatedClass(Flight.class).
	                  addAnnotatedClass(Reservation.class).
	                  addAnnotatedClass(Passenger.class).
	                  buildSessionFactory();
	     } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }
	}
	
//	public static void main(String... args) {
//	    DBConnection db = new DBConnection();
//	    db.createReservation("geniston", "karl", "10PM", "1PM", "SIARGAO", "CEBU", 370);
//	    db.readReservation();
//	    db.updateReservation(14, 737, "MANILA", "CEBU", "12PM", "10AM");
//	    db.deleteReservation(28);
//	    db.searchByFlight(370);
//	    db.searchName("geniston");
//	}
	
	public Passenger addPassenger(String lname, String fname){
		Session session = factory.openSession();
		Transaction t = null;
		Passenger p = new Passenger();
		try {
			t = session.beginTransaction();
			p.setFname(fname);
			p.setLname(lname);
			session.save(p);
			t.commit();
		} catch (HibernateException e) {
			if (t!=null) t.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return p;
	}
	
	public void readFlights() {
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t=session.beginTransaction();
			Query q = session.createQuery("FROM Flight");
			List result = q.list();
			for(Iterator i = result.iterator(); i.hasNext();) {
				Flight res = (Flight) i.next();
				System.out.print("\n\nFlight Code: "+res.getFlightID()+"\n"
						+ "Arrival Time: "+res.getArrive_time()+""
						+ " Departure Time: "+res.getDepart_time()+"\n"
						+ "Origin: "+res.getOrigin()+""
						+ " Destination: "+res.getDestination()+"\n");
				flights.add(new Flight(res.getFlightID(),res.getOrigin(),res.getDestination(),res.getDepart_time(),res.getArrive_time()));
			}
		} catch (HibernateException e) {
			if (t!=null) t.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void createReservation(String lname, String fname, /*String arrive_time, String depart_time, String dest, String orig,*/ int flight){
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Passenger pid = addPassenger(lname,fname);
			Reservation r = new Reservation(pid,flight/*,orig,dest,depart_time,arrive_time*/);
			session.save(r);
			System.out.print("Reservation Created.");
			t.commit();
		} catch (HibernateException e) {
			if (t!=null) t.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void readReservation() {
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t=session.beginTransaction();
			Query q = session.createQuery("FROM Reservation");
			List result = q.list();
			for(Iterator i = result.iterator(); i.hasNext();) {
				Reservation res = (Reservation) i.next();
				Query qu = session.createQuery("FROM Flight F WHERE F.flight_id = :flight_id");
				qu.setParameter("flight_id",res.getFlight_id());
				List myresult = qu.list();
				for(Iterator it = myresult.iterator(); it.hasNext();) {
					Flight flight = (Flight) it.next();
					System.out.print("\n\nReservation Code: "+res.getRes_id()+"\n"
							+ "Arrival Time: "+flight.getArrive_time()+""
							+ " Departure Time: "+flight.getDepart_time()+"\n"
							+ "Flight Code: "+res.getFlight_id()+"\n"
							+ "Origin: "+flight.getOrigin()+""
							+ " Destination: "+flight.getDestination()+"\n"
							+ "Passenger ID: "+res.getPassenger().getID()+"\n"
							+ "Firstname: "+res.getPassenger().getFname()+"\n"
							+ "Lastname: "+res.getPassenger().getLname()+"\n");
				}
//				System.out.print("\n\nReservation Code: "+res.getRes_id()+"\n"
//						+ "Arrival Time: "+res.getArrive_time()+""
//						+ " Departure Time: "+res.getDepart_time()+"\n"
//						+ "Flight Code: "+res.getFlight_id()+"\n"
//						+ "Origin: "+res.getOrigin()+""
//						+ " Destination: "+res.getDestination()+"\n"
//						+ "Passenger ID: "+res.getPassenger().getID());
			}
		} catch (HibernateException e) {
			if (t!=null) t.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void updateReservation(int res_id, int flight_id) {
		Session session = factory.openSession();
		Transaction t = null;
	      try {
	          t = session.beginTransaction();
	          Reservation r = (Reservation)session.get(Reservation.class, res_id); 
	          r.setFlight_id(flight_id);
//	          r.setOrigin(origin);
//	          r.setDestination(destination);
//	          r.setArrive_time(arrive_time);
//	          r.setDepart_time(depart_time);
	          session.update(r);
	          System.out.print("Reservation updated successfully.");
	          t.commit();
	       } catch (HibernateException e) {
	          if (t!=null) t.rollback();
	          e.printStackTrace(); 
	       } finally {
	          session.close(); 
	       }
	}
	
	public void deleteReservation(int res_id) {
		Session session = factory.openSession();
		Transaction t = null;
	      try {
	          t = session.beginTransaction();
	          Reservation r = (Reservation)session.get(Reservation.class, res_id); 
	          session.delete(r); 
	          System.out.print("Reservation deleted successfully.");
	          t.commit();
	       } catch (HibernateException e) {
	          if (t!=null) t.rollback();
	          e.printStackTrace(); 
	       } finally {
	          session.close(); 
	       }
	}
	
	public void searchByFlight(int fid) {
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t=session.beginTransaction();
			Query q = session.createQuery("FROM Flight F WHERE F.flight_id = :flight_id");
			q.setParameter("flight_id",fid);
			List result = q.list();
			for(Iterator i = result.iterator(); i.hasNext();) {
				Flight res = (Flight) i.next();
				Query qu = session.createQuery("FROM Reservation R WHERE R.flight_id = :flight_id");
				q.setParameter("flight_id",res.getFlightID());
				List myresult = qu.list();
				for(Iterator it = myresult.iterator(); it.hasNext();) {
					Reservation flight = (Reservation) i.next();
					System.out.print("\n\nReservation Code: "+flight.getRes_id()+"\n"
							+ "Arrival Time: "+res.getArrive_time()+""
							+ " Departure Time: "+res.getArrive_time()+"\n"
							+ "Flight Code: "+flight.getFlight_id()+"\n"
							+ "Origin: "+res.getOrigin()+""
							+ " Destination: "+res.getDestination()+"\n"
							+ "Firstname: "+flight.getPassenger().getFname()+"\n"
							+ "Lastname: "+flight.getPassenger().getLname()+"\n");
				}
			}
		} catch (HibernateException e) {
			if (t!=null) t.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void searchName(String name) {
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t=session.beginTransaction();
			Criteria c = session.createCriteria(Passenger.class);
			Criterion name1 = Restrictions.like("fname", "%"+name+"%");
			Criterion name2 = Restrictions.like("lname", "%"+name+"%");
			LogicalExpression condition = Restrictions.or(name1, name2);
			c.add(condition);
			List result = c.list();
			for(Iterator i = result.iterator(); i.hasNext();) {
				Passenger res = (Passenger) i.next();
				id.add(new Passenger(res.getID(),res.getLname(),res.getFname()));
			}
			for(int i =0; i<id.size();i++) {
				String sql = "SELECT * FROM reservation WHERE p_passenger_id = :pass_id";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(Reservation.class);
				query.setParameter("pass_id", id.get(i).getID());
				List results = query.list();
				for(Iterator it = results.iterator(); it.hasNext();) {
					Flight myres = (Flight) it.next();
					System.out.print("\n\nFlight Code: "+myres.getFlightID()+"\n"
							+ "Arrival Time: "+myres.getArrive_time()+""
							+ " Departure Time: "+myres.getDepart_time()+"\n"
//							+ "Flight Code: "+myres.getFlight_id()+"\n"
							+ "Origin: "+myres.getOrigin()+""
							+ " Destination: "+myres.getDestination()+"\n"
//							+ "Passenger ID: "+myres.getPassenger().getID()+"\n"
							+ "Firstname: "+id.get(i).getFname()+"\n"
							+ "Lastname: "+id.get(i).getLname());
				}
			}
		} catch (HibernateException e) {
			if (t!=null) t.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
}
