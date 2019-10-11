import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MangKanor {

    private String message;
    private int totalEggs;
    private int EGG_REQUEST= 20;
    private int lacking=0;
    private boolean isPriority = false;
    private List<Integer> eggsLeft = new LinkedList<>();
    private List<Debt> utangList = new LinkedList<>();
    private List<Integer> eggsProduced = new LinkedList<>();

    public synchronized void take(Consumer consumer) {
    	eggsProduced.remove(consumer);
        while (eggsProduced.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        
        isPriority = true;
        notifyAll();
    }

    public synchronized void produce(int eggs, int dayNumber) {
    	eggsLeft.add(eggs);
    	int count=0;    	
    	if(dayNumber>1) {
    		System.out.print("Eggs left yesterday: "+eggsLeft.get(0)+"\n");
    		//eggs+=eggsLeft.get(0);
    		System.out.print("TOTAL EGGS FOR TODAY: "+eggs+"\n");
    	}
    	System.out.print("Day "+dayNumber+"\n");
        for(int i=0;i<EggBusiness.client.size();i++) {
        	if(EggBusiness.client.get(i).getPrioritized()) {
        		if(i<=utangList.size()) {
        			getDebt(eggs,i);
        		}
        	}
        	if(eggs>=EGG_REQUEST) {
        		eggs-=EGG_REQUEST;	
        		EggBusiness.client.set(i, new Consumer(EggBusiness.client.get(i).getConsumer(),EGG_REQUEST,isPriority));
        		eggsProduced.add(EGG_REQUEST);
        		EGG_REQUEST = 20;
        		//isPriority=false;
        	}else if (eggs<EGG_REQUEST){
        		isPriority = true;
        		EggBusiness.client.set(i, new Consumer(EggBusiness.client.get(i).getConsumer(),eggs,isPriority));
        		eggsProduced.add(eggs);
        		totalEggs = EGG_REQUEST - eggs;
        		System.out.print("Promisory note given to "+EggBusiness.client.get(i).getConsumer()+"\n");
        		System.out.print("Lacking "+ totalEggs +" to "+EggBusiness.client.get(i).getConsumer()+"\n");
        		utangList.add(new Debt(EggBusiness.client.get(i).getConsumer(),totalEggs,true));
        		eggs=0;
        	}
        	System.out.print("Client "+EggBusiness.client.get(i).getConsumer()+" Number of Eggs: "+EggBusiness.client.get(i).getEggs()+" Priority: "+EggBusiness.client.get(i).getPrioritized()+"\n");
    		Consumer cons = EggBusiness.client.get(0);
    		EggBusiness.client.set(0, EggBusiness.client.get(i));
    		EggBusiness.client.set(i, cons);
    		eggsLeft.set(0, eggs);
    		System.out.print("Left eggs for today: "+eggsLeft.get(0)+"\n\n");
        }
        isPriority = false;
        notifyAll();
        
    }
    
    public void getDebt(int eggs, int i) {
		for(int j = 0; j<utangList.size();j++) {
			if(utangList.get(j).getDebtName().equals(EggBusiness.client.get(i).getConsumer())) {
				System.out.print("\nPrioritizing "+EggBusiness.client.get(i).getConsumer()+"...\n");
				eggs=eggs-utangList.get(j).toPay();
				EGG_REQUEST = EGG_REQUEST + utangList.get(j).toPay();
				isPriority=false;
				utangList.clear();
				break;
			}
		}
    }
}