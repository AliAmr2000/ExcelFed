//The ancestor for all Event instances 

public abstract class Event implements Comparable<Event> {
	double startTime;
	Trainee trainee;
	public Event(double startTime, 	Trainee trainee) {
		this.startTime = startTime;
		this.trainee = trainee;
	}


	public int compareTo(Event this, Event other) {
		double epsilon = 0.00001;
			if ((this.startTime - other.startTime) < 0 && Math.abs(this.startTime - other.startTime) > epsilon )
			{
				return -1;
			}
			else if((this.startTime - other.startTime) > 0 && Math.abs(this.startTime - other.startTime) > epsilon ) {
				return 1;
			}
			else {
				return 0;
			}
		
	}
	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}



	public abstract void startEvent();


	public Trainee getTrainee() {
		return trainee;
	}
	
	
	

}
