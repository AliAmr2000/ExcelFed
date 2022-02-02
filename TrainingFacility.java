
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;


public class TrainingFacility {
	static double simulationTime;
	ArrayList<Trainee> traineeList = new ArrayList<Trainee>();
	PriorityQueue<Masseur> masseurList = new PriorityQueue<Masseur>();
	PriorityQueue<Coach> coachList = new PriorityQueue<Coach>();
	PriorityQueue<Physiotherapist> physiotherapistList = new PriorityQueue<Physiotherapist>();
	PriorityQueue<Event> events = new PriorityQueue<Event>();
	PriorityQueue<Trainee> trainerQueue = new PriorityQueue<Trainee>();
	PriorityQueue<Trainee> physiotherapistQueue = new PriorityQueue<Trainee>();
	PriorityQueue<Trainee> masseurQueue = new PriorityQueue<Trainee>();
	int maxTrainerQueue;
	int maxMasseurQueue ;
	int maxPhysiotherapistQueue ;
	int invalidAttempt ;
	int canceledAttempt ;
	double totalTrainingQueueWaiting ;
	double totalTherapyQueueWaiting ;
	double totalMassageQueueWaiting ;
	int totalTrainingEntryTimes ;
	int totalTherapyEntryTimes ;
	int totalMassageEntryTimes ;

	
	// The implementation of the simulation according to the stipulations of the Project
	public void startSimulation() {
        while(this.events.size()>0) {
        	TrainingFacility.simulationTime = events.peek().getStartTime();
        	if (this.events.peek() instanceof EntryTrainingQueue) {
        	    if (this.traineeList.get(events.peek().getTrainee().getID()).getAvailability() == 1) {
        	        events.peek().startEvent();
        	     }
        	else {
            	this.incrementCanceledAttempt();
        	    }
            }
        	else if (this.events.peek() instanceof EntryMassageQueue) {
                	if (this.traineeList.get(events.peek().getTrainee().getID()).getAvailability() == 1) {
                		if (events.peek().getTrainee().getMassageEntryCounter() <3) {
                			events.peek().startEvent();
                		}
                        else {
                        	this.incrementInvalidAttempt();                        	
                        }
                	}
                	else {
                		if (events.peek().getTrainee().getMassageEntryCounter() <3) {
                		this.incrementCanceledAttempt();
                		}
                		else {
                        	this.incrementInvalidAttempt();                        	
                		}

                	}
        	}
        	else {
        		events.peek().startEvent();
        	}
    		events.poll();
        }
	
}
		
	
	
	// Calculating the average waiting time in the Training Queue
	
	public double calculateAverageWaitingTraining() {
		Iterator<Trainee> itr = this.traineeList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalTrainingWaitingTime();
		}
		return summation/this.totalTrainingEntryTimes;
		
	}
	
	// Calculating the average waiting time in the Physiotherapy Queue

	
	public double calculateAverageWaitingTherapy() {
		Iterator<Trainee> itr = this.traineeList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalTherapyWaitingTime();
		}
		return summation/this.totalTherapyEntryTimes;
		
	}
	
	// Calculating the average waiting time in the Massage Queue
	public double calculateAverageWaitingMassage() {
		Iterator<Trainee> itr = this.traineeList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalMassageWaitingTime();
		}
		return summation/this.totalMassageEntryTimes;
		
	}
	
	// Calculating the average waiting time spent during the training

	
	public double calculateAverageTrainingTime() {
		Iterator<Coach> itr = this.coachList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalServiceTime();
		}
		
		return summation/this.totalTrainingEntryTimes;
		
	}
	
	// Calculating the average waiting time spent during the Physiotherapy Session

	
	public double calculateAverageTherapyTime() {
		Iterator<Physiotherapist> itr = this.physiotherapistList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalServiceTime();
		}
		return summation/this.totalTherapyEntryTimes;
		
	}
	
	// Calculating the average waiting time spent during the Massage Session

	
	public double calculateAverageMassageTime() {
		Iterator<Masseur> itr = this.masseurList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalServiceTime();
		}
		return summation/this.totalMassageEntryTimes;
		
	}
	
	/// Calculating the average time that is spent by a trainee from entering the Training Queue till leaving the Physiotherapy Session
	public double calculateTurnaroundTime() {
		Iterator<Trainee> itr = this.traineeList.iterator();
		double summation = 0;
		while(itr.hasNext()) {
			summation += itr.next().getTotalTurnaroundTime();
		}
		return summation/this.totalTherapyEntryTimes;
		
	}
	
	
	
	public int getInvalidAttempt() {
		return invalidAttempt;
	}
	
	
	public int getCanceledAttempt() {
		return canceledAttempt;
	}
	
	
	public double calculateSimulationDuration() {
		return  TrainingFacility.simulationTime;
		
	}
	
	
	public int getMaximumLengthTraining() {
		return this.maxTrainerQueue;
		
	}
	
	
	public int getMaximumLengthTherapy() {
		return this.maxPhysiotherapistQueue;
	}
	
	
	public int getMaximumLengthMassage() {
		return this.maxMasseurQueue;
	}
	
	
	
	
	
	// Getters and Setters section 
	

	public void incrementInvalidAttempt() {
		this.invalidAttempt +=1;
	}
	public void incrementCanceledAttempt() {
		this.canceledAttempt +=1;
	}




	public PriorityQueue<Masseur> getMasseurList() {
		return masseurList;
	}
	public PriorityQueue<Coach> getCoachList() {
		return coachList;
	}
	public PriorityQueue<Physiotherapist> getPhysiotherapistList() {
		return physiotherapistList;
	}
	public PriorityQueue<Event> getEvents() {
		return events;
	}
	public PriorityQueue<Trainee> getTrainerQueue() {
		return trainerQueue;
	}
	public PriorityQueue<Trainee> getPhysiotherapistQueue() {
		return physiotherapistQueue;
	}
	public PriorityQueue<Trainee> getMasseurQueue() {
		return masseurQueue;
	}

	public void setMasseurList(PriorityQueue<Masseur> masseurList) {
		this.masseurList = masseurList;
	}
	public void setCoachList(PriorityQueue<Coach> coachList) {
		this.coachList = coachList;
	}
	public void setPhysiotherapistList(PriorityQueue<Physiotherapist> physiotherapistList) {
		this.physiotherapistList = physiotherapistList;
	}
	public void setEvents(PriorityQueue<Event> events) {
		this.events = events;
	}
	public void setTrainerQueue(PriorityQueue<Trainee> trainerQueue) {
		this.trainerQueue = trainerQueue;
	}
	public void setPhysiotherapistQueue(PriorityQueue<Trainee> physiotherapistQueue) {
		this.physiotherapistQueue = physiotherapistQueue;
	}
	public void setMasseurQueue(PriorityQueue<Trainee> masseurQueue) {
		this.masseurQueue = masseurQueue;
	}
	public void setMaxTrainerQueue(int maxTrainerQueue) {
		this.maxTrainerQueue = maxTrainerQueue;
	}
	public void setMaxMasseurQueue(int maxMasseurQueue) {
		this.maxMasseurQueue = maxMasseurQueue;
	}
	public void setMaxPhysiotherapistQueue(int maxPhysiotherapistQueue) {
		this.maxPhysiotherapistQueue = maxPhysiotherapistQueue;
	}
	public int getTotalTrainingEntryTimes() {
		return totalTrainingEntryTimes;
	}
	public int getTotalTherapyEntryTimes() {
		return totalTherapyEntryTimes;
	}
	public int getTotalMassageEntryTimes() {
		return totalMassageEntryTimes;
	}
	public void incrementTotalTrainingEntryTimes() {
		this.totalTrainingEntryTimes += 1;
	}
	public void incrementTotalTherapyEntryTimes() {
		this.totalTherapyEntryTimes += 1;
	}
	public void incrementTotalMassageEntryTimes() {
		this.totalMassageEntryTimes += 1;
	}
	public ArrayList<Trainee> getTraineeList() {
		return traineeList;
	}
	public int getMaxTrainerQueue() {
		return maxTrainerQueue;
	}
	public int getMaxMasseurQueue() {
		return maxMasseurQueue;
	}
	public int getMaxPhysiotherapistQueue() {
		return maxPhysiotherapistQueue;
	}




	public static double getSimulationTime() {
		return simulationTime;
	}







	public double getTotalTrainingQueueWaiting() {
		return totalTrainingQueueWaiting;
	}




	public double getTotalTherapyQueueWaiting() {
		return totalTherapyQueueWaiting;
	}




	public double getTotalMassageQueueWaiting() {
		return totalMassageQueueWaiting;
	}







	public static void setSimulationTime(double simulationTime) {
		TrainingFacility.simulationTime = simulationTime;
	}




	public void setTraineeList(ArrayList<Trainee> traineeList) {
		this.traineeList = traineeList;
	}




	public void setInvalidAttempt(int invalidAttempt) {
		this.invalidAttempt = invalidAttempt;
	}




	public void setCanceledAttempt(int canceledAttempt) {
		this.canceledAttempt = canceledAttempt;
	}






	public void setTotalTrainingQueueWaiting(double totalTrainingQueueWaiting) {
		this.totalTrainingQueueWaiting = totalTrainingQueueWaiting;
	}




	public void setTotalTherapyQueueWaiting(double totalTherapyQueueWaiting) {
		this.totalTherapyQueueWaiting = totalTherapyQueueWaiting;
	}




	public void setTotalMassageQueueWaiting(double totalMassageQueueWaiting) {
		this.totalMassageQueueWaiting = totalMassageQueueWaiting;
	}





	public void setTotalTrainingEntryTimes(int totalTrainingEntryTimes) {
		this.totalTrainingEntryTimes = totalTrainingEntryTimes;
	}




	public void setTotalTherapyEntryTimes(int totalTherapyEntryTimes) {
		this.totalTherapyEntryTimes = totalTherapyEntryTimes;
	}




	public void setTotalMassageEntryTimes(int totalMassageEntryTimes) {
		this.totalMassageEntryTimes = totalMassageEntryTimes;
	}



}
