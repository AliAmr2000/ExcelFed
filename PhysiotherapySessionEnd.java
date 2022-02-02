public class PhysiotherapySessionEnd extends Event {
	Physiotherapist therapist;
	public PhysiotherapySessionEnd (double startTime,Trainee trainee, Physiotherapist therapist) {
    	super (startTime, trainee);
    	this.therapist = therapist;
	}
	public void startEvent() {
    	Trainee.fedex.getPhysiotherapistList().add(this.therapist);
    	Trainee.fedex.incrementTotalTherapyEntryTimes();
		trainee.updateTotalTurnaroundTime(this.startTime - trainee.getTurnaroundCheckPoints());
		if(Trainee.fedex.getPhysiotherapistQueue().size()>0) {
			Trainee.fedex.getPhysiotherapistQueue().peek().updateTotalTherapyWaitingTime(this.startTime - Trainee.fedex.getPhysiotherapistQueue().peek().getCheckPoints());
			Trainee.fedex.getEvents().add(new PhysiotherapySessionStart(this.startTime,Trainee.fedex.getPhysiotherapistQueue().poll(),Trainee.fedex.getPhysiotherapistList().poll()));
		}
		this.trainee.getFedex().getTraineeList().set(this.trainee.getID(), this.trainee);
	    Trainee.fedex.getTraineeList().get(this.trainee.getID()).setAvailability(1);
		}
	
	}