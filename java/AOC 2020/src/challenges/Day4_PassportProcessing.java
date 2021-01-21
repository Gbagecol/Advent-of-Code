package challenges;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import main.Utils;

/**Day 4 Challenge: <a href="https://adventofcode.com/2020/day/4">Passport Processing</a>*/
public class Day4_PassportProcessing extends Challenge {
	
	//variables
	
	/**A list of the input passports combined into one string per passport.*/
	ArrayList<String> passports;
		
	
	//constructors

	public Day4_PassportProcessing() {
		
		//init variables
		inputFilePath = "inputs/day4.txt";
		input = new ArrayList<>();
		passports = new ArrayList<>();
		
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
		
		//combine passports from input into one line each
		
		String passport = ""; //current passport
		
		for(String line : input){
			
			//detect end of current passport
			if(line.equals("") || line.equals(input.get(input.size()-1))) {
				passport = passport.strip();
				passports.add(passport); //add passport to list
				passport = ""; //reset passport string
			}
			//otherwise add line to current passport
			else {
				passport += " " + line;
			}
			
		}
		
		for(String pp : passports)
			System.out.println(pp);

	}

	@Override
	protected void runPartOne() {
		
		int validPassports = 0; //total valid passports
		
		//create set that contains required fields (done by converting String[] -> List<String> -> HashSet<String> to
		//avoid a bunch of .add calls for the set)
		String[] fieldStrings = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
		List<String> fieldList = Arrays.asList(fieldStrings);
		HashSet<String> requiredFields = new HashSet<>(fieldList);
		
		//check all passports
		for(String passport : passports) {
			
			String[] fields = passport.split(" "); //get each passport field
			HashSet<String> fieldsPresent = new HashSet<>(); //set of fields in passport
			
			//add each present field to a set
			for(String field : fields) {
				
				String fieldName = field.substring(0, 3); //isolate field name
				
				//add field if it is not cid
				if(!(fieldName.equals("cid")))
					fieldsPresent.add(fieldName);
				
			}
			
			//validate passport
			if(fieldsPresent.equals(requiredFields))
				validPassports++;
			
		}
		
		System.out.println(validPassports);

	}

	@Override
	protected void runPartTwo() {
		// TODO Auto-generated method stub

	}

}
