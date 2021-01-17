package main;

import challenges.Challenge;
import challenges.Day1_ReportRepair;
import challenges.Day2_PasswordPhilosophy;
import challenges.Day3_TobogganTrajectory;

/**Driver method for all challenges.*/
public class Driver {

	public static void main(String[] args) {
		
		//Replace the class name after the "new" keyword with the name of the challenge class you want to use.
		Challenge challenge = new Day3_TobogganTrajectory();
		
		challenge.run();

	}

}
