package challenges;

import java.util.ArrayList;

/**A template class for challenges.*/
public abstract class Challenge {
	
	//variables
	
	/**The path to the input file for this challenge.*/
	protected String inputFilePath;
	/**The challenge input as read from the input file, represented as a list of strings.*/
	protected ArrayList<String> input;

	
	//methods
	
	/**Reads the input file for the challenge and initializes appropriate variables.*/
	protected abstract void loadInput();
	
	/**Runs the first half of the challenge.*/
	protected abstract void runPartOne();
	
	/**Runs the second half of the challenge.*/
	protected abstract void runPartTwo();
	
	/**Runs both parts of the challenge.*/
	public void run() {
		
		System.out.println("          PART ONE          ");
		System.out.println("----------------------------\n");
		
		runPartOne();
		
		System.out.println("          PART TWO          ");
		System.out.println("----------------------------\n");
		
		runPartTwo();
		
	}
	
}
