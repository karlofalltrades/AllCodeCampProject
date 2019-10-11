import java.util.Random;

public class Producer implements Runnable {
    private int select;
    private MangKanor drop;
    private int MIN_EGGS = 80;
    private int MAX_EGGS = 120;
    private int day=1;

    public Producer(MangKanor drop) {
    	this.drop=drop;
    }

    public void run() {
        
        while(true) {
        	try {
				Thread.sleep(2000);
				select = pickOne(MIN_EGGS,MAX_EGGS);
				System.out.print("\n==========================================================\n");
				System.out.print("Number of eggs produced: "+select+"\n");
				drop.produce(select,day);
				day++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
    }
    
    protected int pickOne(int minimum, int maximum) {
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
	}
}