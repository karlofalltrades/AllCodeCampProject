
public class Audience extends Thread{
	private int select;
	
	public Audience(){}
	
	public void run() {
		try {
			while(true) {
			Thread.sleep(100);
			select = pickOne(0,MyRace.horse.length);
			MyRace.horse[select].eat();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int pickOne(int minimum, int maximum) {
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
	}

}
