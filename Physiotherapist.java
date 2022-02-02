

public class Physiotherapist extends Worker {
	double serviceTime;
	public Physiotherapist(int ID, double serviceTime) {
		super (ID);
		this.serviceTime = serviceTime;
	}
	public double getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(double serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	

}
