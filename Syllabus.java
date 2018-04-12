import java.io.File;
//import java.io.PrintWriter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import java.io.FileInputStream;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.StringTokenizer;

/*
 * Created from the syllabus file by interpreting it and saving the contained courses into an array
 */
public class Syllabus {

	
	private Course[] courses;

	
	public Syllabus(File sylFile) {
		
	}
	
}

// Example of file to be read
//COMP108	Computer_Science_Industrial_Experience_Reflective_Learning_I	3
//P
//C
//
//COMP201	Introduction_to_Computing	3
//P	MATH201
//C
//
//COMP208	Computer_Science_Industrial_Experience_Reflective_Learning_II	3
//P	COMP108
//C
//
//COMP218	Fundamentals_of_Programming	3
//P	MATH201
//C	 
//
//COMP248	Object-Oriented_Programming_I	3.5
//P	MATH204
//C	COMP201
//
//COMP228	System_Hardware	3
//P	COMP248
//C	
//
//COMP249	Object-Oriented_Programming_II	3.5
//P	COMP248
//C	
//
//COMP371	Computer_Graphics	4
//P	COMP248
//C	COMP249
//
//COMP376	Introduction_to_Game_Development	4
//P	COMP371
//C	COMP371
//
//COMP228	System_Hardware	3
//P	COMP248
//C	
