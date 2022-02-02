public class EntryMassageQueue extends Event{
      double massageDuration;
 
    public EntryMassageQueue (double startTime,Trainee trainee, double massageDuration) {
    	super (startTime,trainee);
    	this.massageDuration = massageDuration;
    }

    public void startEvent() {
	    Trainee.fedex.getTraineeList().get(this.trainee.getID()).setAvailability(0);
    	trainee.incrementMassageEntryCounter();
        if (Trainee.fedex.getMasseurList().size()>0) {
        	Trainee.fedex.getEvents().add(new MassageSessionStart (this.startTime, this.trainee,Trainee.fedex.getMasseurList().poll(),this.massageDuration));
        	}
    	else {
    		trainee.updateCheckPoints(this.startTime);
    		trainee.setCurrentMessageDuration(this.massageDuration);
    		Trainee.fedex.getMasseurQueue().add(this.trainee);
    			if (Trainee.fedex.getMaximumLengthMassage()<Trainee.fedex.getMasseurQueue().size()) {
    				Trainee.fedex.setMaxMasseurQueue(Trainee.fedex.getMasseurQueue().size());	
    			}
    	
    	}
    }	
    
}
