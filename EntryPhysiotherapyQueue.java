public class EntryPhysiotherapyQueue extends Event {


    public EntryPhysiotherapyQueue (double startTime,Trainee trainee) {
    	super(startTime,trainee);
    }

    public void startEvent() {
    	if (Trainee.fedex.getPhysiotherapistList().size()>0) {
    		Trainee.fedex.getEvents().add(new PhysiotherapySessionStart (this.startTime, this.trainee,Trainee.fedex.getPhysiotherapistList().poll()));

        	}
    	else {    		    
    			this.trainee.updateCheckPoints(startTime);
    			Trainee.fedex.getPhysiotherapistQueue().add(this.trainee);
    			if (Trainee.fedex.getMaximumLengthTherapy()<Trainee.fedex.getPhysiotherapistQueue().size()) {
    				Trainee.fedex.setMaxPhysiotherapistQueue(Trainee.fedex.getPhysiotherapistQueue().size());    				
    			}
    		}
    	}
    	
    
}
