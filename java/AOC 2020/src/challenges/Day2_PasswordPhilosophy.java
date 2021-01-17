package challenges;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import main.Utils;


/**Day 2 Challenge: <a href="https://adventofcode.com/2020/day/2">Password Philosophy</a>*/
public class Day2_PasswordPhilosophy extends Challenge {
	
	//variables
	
	
	//constructors

	public Day2_PasswordPhilosophy() {
		
		//init variables
		inputFilePath = "inputs/day2.txt";
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
		
		int validPasswords = 0; //number of valid passwords
		
		//check each password
		for(String line : input) {
			
			String[] components = line.split(" "); //get each part of the input line
			
			//get upper and lower bounds
			String[] bounds = components[0].split("-");
			int lowerBound = Integer.parseInt(bounds[0]);
			int upperBound = Integer.parseInt(bounds[1]);
			
			char validationChar = components[1].charAt(0); //char to search for
			String password = components[2]; //password to validate
			int charCount = 0; //number of appearances of the validation character in the password
			
			//count appearances of validation char
			for(int x = 0; x < password.length(); x++)
				if(password.charAt(x) == validationChar)
					charCount++;
			
			//validate password
			if(charCount >= lowerBound && charCount <= upperBound)
				validPasswords++;
			
		}
		
		System.out.println(validPasswords);

	}

	@Override
	protected void runPartTwo() {
		
		int validPasswords = 0; //number of valid passwords
		
		//check each password
		for(String line : input) {
			
			String[] components = line.split(" "); //get each part of the input line
			
			//get first and second indices
			String[] indices = components[0].split("-");
			int pos1 = Integer.parseInt(indices[0]) - 1;
			int pos2= Integer.parseInt(indices[1]) - 1;
			
			char validationChar = components[1].charAt(0); //char to search for
			String password = components[2]; //password to validate
			
			//validate password
			if((password.charAt(pos1) == validationChar) != (password.charAt(pos2) == validationChar))
				validPasswords++;
			
		}
		
		System.out.println(validPasswords);

	}

}
