public class EntryTrainingQueue extends Event {
    double CurrentTrainingTime;
    public EntryTrainingQueue ( double startTime, Trainee trainee, double trainingDuration ) {
    	super(startTime,trainee);
    	this.CurrentTrainingTime = trainingDuration; 	
    	
    }

    public void startEvent() {
	    Trainee.fedex.getTraineeList().get(this.trainee.getID()).setAvailability(0);
		this.trainee.updateTurnaroundCheckPoints(startTime);
    	if (Trainee.fedex.getCoachList().size()>0) {
    		Trainee.fedex.getEvents().add(new TrainingStart (this.startTime, this.trainee,Trainee.fedex.getCoachList().poll(), this.CurrentTrainingTime ));

        	}
    	else 
    	{
    		trainee.updateCheckPoints(this.startTime);
    		trainee.setCurrentTrainingTime(CurrentTrainingTime);
    		Trainee.fedex.getTrainerQueue().add(this.trainee);
       		if (Trainee.fedex.getTrainerQueue().size()>Trainee.fedex.getMaximumLengthTraining()) {
    			Trainee.fedex.setMaxTrainerQueue(Trainee.fedex.getTrainerQueue().size());
    	    }
       
    	}
    	} 	
    

}
