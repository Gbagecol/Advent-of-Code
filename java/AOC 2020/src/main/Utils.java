package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**Some (one) utility functions.*/
public class Utils {
	
	/**Reads the contents of the file at the given path and returns them as a list of strings, where each element in the list is a line in the file.
	 * @param path: The absolute file path.
	 * @return The contents of the file in an ArrayList.
	 * @throws FileNotFoundException 
	 * @throws IOException */
	public static ArrayList<String> readFile(String path) throws FileNotFoundException, IOException{
		
		FileInputStream file = null; //input stream
		Scanner fileIn = null; //scanner to read file
		ArrayList<String> contents = new ArrayList<String>(); //file contents
		
		//attempt to read file contents
		try {
			
			file = new FileInputStream(path); //open file
			fileIn = new Scanner(file); //open scanner
			
			//read each line into list
			while(fileIn.hasNext()) {
				contents.add(fileIn.nextLine());
			}
			
		}
		catch(FileNotFoundException e) {
			throw e;
		}
		finally {
			file.close();
			fileIn.close();
		}
		
		return contents;
		
	}

}
