public class TrainingStart extends Event {
    Coach coach;
    double currentTrainingTime;
	public TrainingStart (double startTime, Trainee trainee, Coach coach, double trainingTime) {
    	super(startTime,trainee);
    	this.coach = coach;
    	this.currentTrainingTime = trainingTime;
	}
    public void startEvent() {
    	this.coach.updateTotalServiceTime(this.currentTrainingTime);
    	Trainee.fedex.getEvents().add(new TrainingEnd(this.startTime + this.currentTrainingTime, this.trainee, this.coach));
    }
    
}
