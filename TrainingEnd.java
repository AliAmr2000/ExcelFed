public class TrainingEnd extends Event {
    Coach coach;
	public TrainingEnd (double startTime, Trainee trainee, Coach coach) {
    	super (startTime, trainee);
    	this.coach = coach;
	}
	public void startEvent() {
		Trainee.fedex.getCoachList().add(this.coach);
		Trainee.fedex.getEvents().add(new EntryPhysiotherapyQueue(this.startTime,this.trainee));
    	Trainee.fedex.incrementTotalTrainingEntryTimes();
		if(Trainee.fedex.getTrainerQueue().size()>0) {
			Trainee.fedex.getTrainerQueue().peek().updateTotalTrainingWaitingTime(this.startTime - Trainee.fedex.getTrainerQueue().peek().getCheckPoints() );
			Trainee.fedex.getEvents().add(new TrainingStart(this.startTime,Trainee.fedex.getTrainerQueue().peek(),Trainee.fedex.getCoachList().poll(),Trainee.fedex.getTrainerQueue().poll().getCurrentTrainingTime() ));
			
		}
	}
}	
	
