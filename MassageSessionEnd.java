public class MassageSessionEnd extends Event {
	Masseur masseur;

	public MassageSessionEnd (double startTime,Trainee trainee, Masseur masseur) {
    	super (startTime, trainee);
    	this.masseur = masseur;
	}
    public void startEvent() {
    	Trainee.fedex.incrementTotalMassageEntryTimes();
		Trainee.fedex.getMasseurList().add(this.masseur);
         if (Trainee.fedex.getMasseurQueue().size()>0) {
        	 Trainee.fedex.getMasseurQueue().peek().updateTotalMassageWaitingTime(startTime-Trainee.fedex.getMasseurQueue().peek().getCheckPoints());
        	 Trainee.fedex.getEvents().add(new MassageSessionStart(this.startTime,Trainee.fedex.getMasseurQueue().peek(),Trainee.fedex.getMasseurList().poll(),Trainee.fedex.getMasseurQueue().poll().getCurrentMessageDuration()));
    	}
         Trainee.fedex.getTraineeList().set(this.trainee.getID(), this.trainee); 
 	     Trainee.fedex.getTraineeList().get(this.trainee.getID()).setAvailability(1);

     	
    }

}
