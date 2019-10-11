
public class Debt {
	private String consumer;
	private int toPay;
	private boolean hasUtang;
	
	public Debt(String consumer, int toPay, boolean hasUtang) {
		this.consumer=consumer;
		this.toPay=toPay;
		this.hasUtang=hasUtang;
	}
	
	public Debt() {}
	
	public String getDebtName() {
		return consumer;
	}
	
	public int toPay() {
		return toPay;
	}
	
	public boolean hasUtang(){
		return hasUtang;
	}

}
