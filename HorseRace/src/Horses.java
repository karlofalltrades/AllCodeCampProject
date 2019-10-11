
public class Horses  extends Thread{
	private int x=0;
	private int y=0;
	private int hid;
	
	public Horses() {}
	
	public Horses(int x, int y ,int hid) {
		this.x=x;
		this.y=y;
		this.hid=hid;
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public int getID() {
		return hid;
	}
	public void run() {
		while(x<MyRace.TRACK) {
			try {
				x+=10;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Podium.setPodium(x,y,hid);
		//System.out.print(hid);
	}
	protected void eat() {
		if(x<MyRace.TRACK) {
			x+=20;
		}
	}
}
