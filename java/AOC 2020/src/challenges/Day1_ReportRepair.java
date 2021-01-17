package challenges;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import main.Utils;

/**Day 1 Challenge: <a href="https://adventofcode.com/2020/day/1">Report Repair</a>*/
public class Day1_ReportRepair extends Challenge {

	public Day1_ReportRepair() {
		
		//init variables
		inputFilePath = "inputs/day1.txt";
		input = new ArrayList<>();
		
		loadInput();
		
	}

	@Override
	protected void loadInput() {
		
		try {
			input = Utils.readFile("inputs/day1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void runPartOne() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void runPartTwo() {
		// TODO Auto-generated method stub

	}

}
