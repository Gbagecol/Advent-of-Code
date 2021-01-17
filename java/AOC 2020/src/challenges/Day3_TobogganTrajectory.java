package challenges;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import main.Utils;

/**Day 3 Challenge: <a href="https://adventofcode.com/2020/day/3">Toboggan Trajectory</a>*/
public class Day3_TobogganTrajectory extends Challenge {
	
	//constructors

	public Day3_TobogganTrajectory() {
		
		//init variables
		inputFilePath = "inputs/day3.txt";
		input = new ArrayList<>();
		
		loadInput();
		
	}
	
	
	//methods

	@Override
	protected void loadInput() {
		
		try {
			input = Utils.readFile(inputFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void runPartOne() {
		
		//current x and y coordinates
		int xPos = 0;
		int yPos = 0;
		
		int treesEncountered = 0; //how many trees are hit
		
		//move sled and check each row for tree encounter
		for(yPos = 0; yPos < input.size(); yPos++) {
			
			//check for tree
			if(input.get(yPos).charAt(xPos) == '#')
				treesEncountered++;
			
			xPos += 3;
			
			//wrap around if bounds of map exceeded
			if(xPos >= input.get(yPos).length())
				xPos = xPos % input.get(yPos).length();
			
		}
		
		System.out.println(treesEncountered);

	}

	@Override
	protected void runPartTwo() {
		
		//had to use long because int was returning the wrong answer
		long result = calculateTreesHit(1, 1) * calculateTreesHit(3, 1) * calculateTreesHit(5, 1) * calculateTreesHit(7, 1) * 
				calculateTreesHit(1, 2);
		System.out.println(result);

	}
	
	/**Determines how many trees are encountered when traveling in a given slope.
	 * @param xChange How much the x position changes by each step.
	 * @param yChange How much the y position changes by each step.
	 * @return The total number of trees hit.*/
	private	long calculateTreesHit(int xChange, int yChange) {
		
		//current x and y positions
		int xPos = 0;
		int yPos = 0;
		
		long treesEncountered = 0; //how many trees are hit
		
		//check for trees
		for(yPos = 0; yPos < input.size(); yPos += yChange) {
			
			//check for tree
			if(input.get(yPos).charAt(xPos) == '#')
				treesEncountered++;
			
			xPos += xChange;
			
			//wrap around if bounds of map exceeded
			if(xPos >= input.get(yPos).length())
				xPos = xPos % input.get(yPos).length();
			
		}
		
		return treesEncountered;
		
	}

}
