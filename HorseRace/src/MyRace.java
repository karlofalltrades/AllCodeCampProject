import java.applet.*;
import java.awt.*;

import javax.swing.JApplet;

public class MyRace extends Applet implements Runnable{
	
	static Horses[] horse = new Horses[10];
	static Podium[] podium = new Podium[10];
	Audience throwspinach;
	Image img,img2;
	Image gold,silver,bronze;
	Image flute;
	AudioClip gong;
	int x=0,y=0;
	protected static int TRACK=1000;
	
	public void init() {
	  img = getImage(getDocumentBase(), "runningman.gif");
	  img2 = getImage(getDocumentBase(), "white.jpeg");
	  gold = getImage(getDocumentBase(), "gold.png");
	  silver = getImage(getDocumentBase(), "silver.png");
	  bronze = getImage(getDocumentBase(), "bronze.png");
	  flute = getImage(getDocumentBase(), "flute_player.gif");
	  gong = getAudioClip(getDocumentBase(), "sounds.wav");
	  gong.play();
	  //setBackground(Color.white);
	  for(int i = 0; i < horse.length; i++) {
		  horse[i] = new Horses(0,y,i);
		  y+=50;
	  }
	  resize(1500,y);
	}
	public void start() {
		Thread th = new Thread(this);
		th.start();
		throwspinach = new Audience();
		throwspinach.start();
		for(int i=0;i<horse.length;horse[i].start(),i++);
	}
   	public void paint (Graphics g) {
   		for(int i=0;i<horse.length;i++) {
   			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   			g.drawImage(img2, horse[i].getX()-50, horse[i].getY(), 50, 50, this);
   			g.drawImage(img, horse[i].getX(), horse[i].getY(), 50, 50, this);
   		}
   		g.drawLine(1025, 0, 1025, y);
   		g.drawImage(flute, 1200, 400, 100, 100, this);
   	   	if(podium[0]!=null) {
   	   		g.drawImage(gold,1050,podium[0].getY(), 30, 30,this);
   	   		//gong.stop();
   	   	   	if(podium[1]!=null) {
   	   	   		g.drawImage(silver,1050,podium[1].getY(), 30, 30,this);
   	    	   	if(podium[2]!=null) {
   	    	   		g.drawImage(bronze,1050,podium[2].getY(), 30, 30,this);
   	    	   	   	if(podium[9]!=null) {
   	    	   	   		gong.stop();
   	    	   	   	}
   	    	   	}
   	   	   	}
   	   	}
   	}
   	
	@Override
	public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
	}
}