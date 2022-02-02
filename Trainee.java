

public class Trainee implements Comparable <Trainee>{
	double totalTrainingWaitingTime = 0;
	double totalTherapyWaitingTime = 0;
	double totalMassageWaitingTime = 0;
	double totalTurnaroundTime = 0;
	int skillLevel;
	double currentTrainingTime = 0;
	int ID;
	double currentMessageDuration;
	public static TrainingFacility fedex;
	double waitingTime = 0;
	double checkPoints;
	double turnaroundCheckPoints;
	int massageEntryCounter = 0;
	int availability = 1;

	public Trainee(int ID, int skillLevel) {
		this.ID = ID;
		this.skillLevel = skillLevel;
	}

	public int compareTo(Trainee other) {
		double epsilon = 0.00001;
		if (Trainee.fedex.getTrainerQueue().contains(this) == true || Trainee.fedex.getTrainerQueue().contains(other) == true) {
			if ((this.checkPoints - other.checkPoints) < 0 && Math.abs(this.checkPoints - other.checkPoints) > epsilon) {
				return -1;
			}
			else if ((this.checkPoints - other.checkPoints) > 0 && Math.abs(this.checkPoints - other.checkPoints) > epsilon) {
				return 1;
			}
			else {
				return this.ID - other.ID;
			}
			
		}
		else if(Trainee.fedex.getPhysiotherapistQueue().contains(this) == true || Trainee.fedex.getPhysiotherapistQueue().contains(other) == true) {
			if ((this.currentTrainingTime - other.currentTrainingTime) > 0 && Math.abs(this.currentTrainingTime - other.currentTrainingTime) > epsilon) {
				return -1;
			}
			else if ((this.currentTrainingTime - other.currentTrainingTime) < 0 && Math.abs(this.currentTrainingTime - other.currentTrainingTime) > epsilon) {
				return 1;
			}
			else {
				if ((this.checkPoints - other.checkPoints) < 0 && Math.abs(this.checkPoints - other.checkPoints) > epsilon) {
					return -1;
				}
				else if ((this.checkPoints - other.checkPoints) > 0 && Math.abs(this.checkPoints - other.checkPoints) > epsilon ) {
					return 1;
				}
				else {
					return this.ID - other.ID;
				}
			}
		}
		else if (Trainee.fedex.getMasseurQueue().contains(this) == true || Trainee.fedex.getMasseurQueue().contains(other) == true) {
			if (this.skillLevel > other.skillLevel) {
				return -1;
			}
			else if (this.skillLevel < other.skillLevel) {
				return 1;
			}
			else {
				if ((this.checkPoints - other.checkPoints) < 0 && Math.abs(this.checkPoints - other.checkPoints) > epsilon) {
					return -1;
				}
				else if ((this.checkPoints - other.checkPoints) > 0 && Math.abs(this.checkPoints - other.checkPoints) > epsilon ) {
					return 1;
				}
				else {
					return this.ID - other.ID;
				}
			}
		}
		else {
			return this.ID - other.ID;
		}
		}
	
	public int getSkillLevel() {
		return skillLevel;
	}
	public double getCurrentTrainingTime() {
		return currentTrainingTime;
	}
	public int getID() {
		return ID;
	}

	public void setCurrentTrainingTime(double currentTrainingTime) {
		this.currentTrainingTime = currentTrainingTime;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public TrainingFacility getFedex() {
		return fedex;
	}
	public double getTotalTrainingWaitingTime() {
		return totalTrainingWaitingTime;
	}
	public double getTotalTherapyWaitingTime() {
		return totalTherapyWaitingTime;
	}
	public double getCheckPoints() {
		return checkPoints;
	}
	public void updateTotalTrainingWaitingTime(double time) {
		this.totalTrainingWaitingTime += time;
	}
	public void updateTotalTherapyWaitingTime(double time) {
		this.totalTherapyWaitingTime += time;
	}
	public void updateCheckPoints(double checkPoints) {
		this.checkPoints = checkPoints;
	}
	public double getTotalTurnaroundTime() {
		return totalTurnaroundTime;
	}
	public void updateTotalTurnaroundTime(double time) {
		this.totalTurnaroundTime += time;
	}
	public double getTurnaroundCheckPoints() {
		return turnaroundCheckPoints;
	}
	public void updateTurnaroundCheckPoints(double time) {
		this.turnaroundCheckPoints = time;
	}

	public int getMassageEntryCounter() {
		return massageEntryCounter;
	}

	public void incrementMassageEntryCounter() {
		this.massageEntryCounter += 1;
	}

	public double getTotalMassageWaitingTime() {
		return totalMassageWaitingTime;
	}

	public void updateTotalMassageWaitingTime(double time) {
		this.totalMassageWaitingTime += time;
	}

	public static void setFedex(TrainingFacility fedex) {
		Trainee.fedex = fedex;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public double getCurrentMessageDuration() {
		return currentMessageDuration;
	}

	public void setCurrentMessageDuration(double massageDuration) {
		this.currentMessageDuration = massageDuration;
	}

	public void setCheckPoints(double checkPoints) {
		this.checkPoints = checkPoints;
	}


	
	
}
