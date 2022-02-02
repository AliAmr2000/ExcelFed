
public class MassageSessionStart extends Event {
	double MassageDuration;
	Masseur masseur;

	public MassageSessionStart (double startTime,Trainee trainee, Masseur masseur, double MassageDuration) {
    	super (startTime, trainee);
    	this.masseur = masseur;
    	this.MassageDuration = MassageDuration;
	}
    public void startEvent() {
    	this.masseur.updateTotalServiceTime(this.MassageDuration);
    	Trainee.fedex.getEvents().add(new MassageSessionEnd((this.startTime + this.MassageDuration), this.trainee, this.masseur));
    }

}
