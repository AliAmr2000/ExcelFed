

public class PhysiotherapySessionStart extends Event {
	Physiotherapist therapist;
	public PhysiotherapySessionStart (double startTime,	Trainee trainee, Physiotherapist therapist) {
    	super (startTime, trainee);
    	this.therapist = therapist;
	}
    public void startEvent() {
    	this.therapist.updateTotalServiceTime(this.therapist.getServiceTime());
    	Trainee.fedex.getEvents().add(new PhysiotherapySessionEnd(this.startTime + this.therapist.getServiceTime(), this.trainee, this.therapist));
    }

}
