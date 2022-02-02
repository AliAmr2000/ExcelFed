//The ancestor of all the workers and employee in the Training Facility

public class Worker implements Comparable<Worker> {
	int accessTimes;
	double totalServiceTime;
	int ID;

	public Worker(int ID) {
	this.accessTimes = 0;
	this.totalServiceTime = 0;
	this.ID = ID;
	}
	public int compareTo(Worker other) {
		return  this.ID - other.ID ;
	}
	public int getAccessTimes() {
		return accessTimes;
	}
	public double getTotalServiceTime() {
		return totalServiceTime;
	}
	public void incrementAccessTimes() {
		this.accessTimes +=1;
	}
	//Total service time is calculated in order to figure out with the average time spent by a trainee while accessing a specific service offered by a worker
	public void updateTotalServiceTime(double additionalTime) {
		this.totalServiceTime += additionalTime;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}
	
	
