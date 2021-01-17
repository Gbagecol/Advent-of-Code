package challenges;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import main.Utils;


/**Day 1 Challenge: <a href="https://adventofcode.com/2020/day/1">Report Repair</a>*/
public class Day1_ReportRepair extends Challenge {
	
	//variables
	
	/**The problem input converted to a list of integers.*/
	ArrayList<Integer> inputNumbers;
	
	
	//constructors

	public Day1_ReportRepair() {
		
		//init variables
		inputFilePath = "inputs/day1.txt";
		input = new ArrayList<>();
		inputNumbers = new ArrayList<>();
		
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
		
		//convert all lines to integers
		for(String num : input)
			inputNumbers.add(Integer.parseInt(num));

	}

	@Override
	protected void runPartOne() {
		
		//check each pair of numbers to see if they add to 2020
		for(int x = 0; x < inputNumbers.size(); x++) {
			for(int y = x+1; y < inputNumbers.size(); y++) {
				if(inputNumbers.get(x) + inputNumbers.get(y) == 2020) {
					System.out.println(inputNumbers.get(x) * inputNumbers.get(y)); //multiply numbers
					return;
				}
			}
		}

	}

	@Override
	protected void runPartTwo() {
		
		//check each set of 3 numbers (an incredible complexity of O(n^3))
		for(int x = 0; x < inputNumbers.size(); x++) {
			for(int y = x+1; y < inputNumbers.size(); y++) {
				for(int z = y+1; z < inputNumbers.size(); z++) {
					if(inputNumbers.get(x) + inputNumbers.get(y) + inputNumbers.get(z) == 2020) {
						System.out.println(inputNumbers.get(x) * inputNumbers.get(y) * inputNumbers.get(z)); //multiply numbers
						return;
					}
				}
			}
		}

	}

}
