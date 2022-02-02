
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class project2main {

	public static void main(String[] args) throws FileNotFoundException {
	      Scanner in = new Scanner(new File (args[0]));
	      
	      PrintStream out = new PrintStream(new File (args[1]));
	      
	      TrainingFacility fedex = new TrainingFacility();
	      
	      int numberofTrainee = in.nextInt();
	      
	      // Adding Trainees to the records of the Training Facility
	      for (int counter = 0; counter<numberofTrainee; counter ++) {
	    	  fedex.getTraineeList().add(new Trainee(in.nextInt(),in.nextInt()));
	      }
	      
	     Trainee.fedex = fedex;
	      
	     //Storing Events in a priority queue 
	     int numberofEvents = in.nextInt();
	      
	      for (int counter = 0; counter<numberofEvents; counter ++) {
	    	  String marker = in.next();
	    	  if (marker.equals("t")) {
	    		  int ID = in.nextInt();
	    		  double startTime = in.nextDouble();
	    		  double trainingTime = in.nextDouble();
	    			  fedex.getEvents().add(new EntryTrainingQueue(startTime,fedex.getTraineeList().get(ID),trainingTime));  
	    	  }
	    	  else {
	    		  int ID = in.nextInt();
	    		  double startTime = in.nextDouble();
	    		  double massageTime = in.nextDouble();
	    		  fedex.getEvents().add(new EntryMassageQueue(startTime,fedex.getTraineeList().get(ID),massageTime));
	    	  }
	      }
	      
	      int numberTherapists = in.nextInt();
	      
	      // Adding Physiotherapists to the records of the Training Facility
	      for (int counter = 0; counter < numberTherapists; counter ++) {
	      double t = in.nextDouble();
	      fedex.getPhysiotherapistList().add(new Physiotherapist (counter,t));
	      }
	      int numberCoaches = in.nextInt();
	      
	      // Adding Trainers to the records of the Training Facility
	      for (int counter = 0; counter < numberCoaches; counter ++) {
	      fedex.getCoachList().add(new Coach (counter));
	      }
	      int numberMasseurs = in.nextInt();
	      
	      for (int counter = 0; counter < numberMasseurs; counter ++) {
	      fedex.getMasseurList().add(new Masseur (counter));
	      }
	      
	      
	      // Initiating the simulation
	      fedex.startSimulation();
	      
	      
	      
	      
	      ////////////1
	      out.print(fedex.getMaximumLengthTraining());
	      out.print("\n");

	      
	      /////////////2
	      out.print(fedex.getMaximumLengthTherapy());	
	      out.print("\n");

	      
	      //////////////////3
	       out.print(fedex.getMaximumLengthMassage());	
	       out.print("\n");

	      
	      /////////////////4
	      out.print(String.format("%.3f", fedex.calculateAverageWaitingTraining()));
	      out.print("\n");

	      ///////////////5
	      out.print(String.format("%.3f", fedex.calculateAverageWaitingTherapy()));
	      out.print("\n");

	      
	      ///////////////6
	      out.print(String.format("%.3f", fedex.calculateAverageWaitingMassage()));
	      out.print("\n");

	     
	      /////////////////7
	      out.print(String.format("%.3f", fedex.calculateAverageTrainingTime()));
	      out.print("\n");

	      
	      //////////////////8
	      out.print(String.format("%.3f", fedex.calculateAverageTherapyTime()));
	      out.print("\n");

	      /////////////////9
	      out.print(String.format("%.3f", fedex.calculateAverageMassageTime()));	
	      out.print("\n");


	      
	      //////////////////10
	      out.print(String.format("%.3f", fedex.calculateTurnaroundTime()));	
	      out.print("\n");


	    	  
	      /////////////////11
	      Trainee trainee = fedex.getTraineeList().get(0);
	      for (Trainee train : fedex.getTraineeList()) {
	    	  if (train.getTotalTherapyWaitingTime() > trainee.getTotalTherapyWaitingTime())
	    		  trainee = train;
	      }
	      out.print(trainee.getID()+" ");
	      out.print(String.format("%.3f",trainee.getTotalTherapyWaitingTime()));
	      out.print("\n");

	      
	      /////////////////12
	      boolean threeAccessesCheck = false;
	      Trainee trainee1 = fedex.getTraineeList().get(0);
	      for (Trainee train : fedex.getTraineeList()) {
	    	  if (train.getTotalMassageWaitingTime() < trainee1.getTotalMassageWaitingTime())
	    		  trainee1 = train;
	    	  if (train.getMassageEntryCounter() == 3) {
	    		  threeAccessesCheck = true;
	    	  }
	      }
	      if (threeAccessesCheck == true) {
	      out.print(trainee1.getID()+" ");
	      out.print(String.format("%.3f",trainee1.getTotalMassageWaitingTime()));
	      out.print("\n");
	      }
	      else {
	    	  out.print("-1 -1");;
	    	  out.print("\n");
	      }

	      
	      /////////////////13
	      out.print(fedex.getInvalidAttempt());
	      out.print("\n");
	      
	      /////////////////14
	      out.print(fedex.getCanceledAttempt());
	      out.print("\n");
	      
	      /////////////////15
	      out.print(String.format("%.3f", fedex.calculateSimulationDuration()));
	      out.print("\n");
	      
	      //////////////
	      
	      //Closing files after the end of operations
	      in.close();
	      out.close();


	      

	      

	      

}
}
