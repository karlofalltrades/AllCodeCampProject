import java.util.Random;

public class Consumer extends Thread  {
    private String consumerName;
    private int eggReceived;
    private boolean isPriority = false;
    public Consumer(String consumerName) {
    	this.consumerName=consumerName;
    }
    
    public Consumer() {}
    
    public Consumer(String consumerName, int eggs, boolean isPriority) {
    	this.consumerName=consumerName;
    	this.eggReceived=eggs;
    	this.isPriority=isPriority;
    }
    
    public String getConsumer() {
    	return consumerName;
    }
    
    public int getEggs() {
    	return eggReceived;
    }
    
    public boolean getPrioritized() {
    	return isPriority;
    }

    public void run() {
        MangKanor kanor = new MangKanor();
        for(int i = 0; i<EggBusiness.client.size();i++) {
        	kanor.take(this);
        }
    }
}