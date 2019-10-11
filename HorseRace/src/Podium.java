public class Podium extends Horses{
	private int x,y,hid;

	public Podium(int x, int y, int hid) {
	this.x=x;
	this.y=y;
	this.hid=hid;
	}
	
	protected static void setPodium(int x, int y, int hid) {
		for(int i=0;i<MyRace.horse.length;i++) {
			if(MyRace.podium[i]==null) {
				MyRace.podium[i]= new Podium(x,y,hid);
				System.out.print(MyRace.podium[i].getHid());
				break;
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHid() {
		return hid;
	}

}
