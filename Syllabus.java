import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

/*
 * Created from the syllabus file by interpreting it and saving the contained courses into an array
 */
public class Syllabus {

	private Course[] courses;
//	private CourseList coursesList;

	public Syllabus(String fileName) {

	//	coursesList = new CourseList();
		
		
		
		// ... 
		
	//	courses.List.insertAtIndex( Course c , coursesList.get(size));
		
		
		String s = readFile(fileName);
		courses = null;
		// System.out.println(s);
		courses = breakFile(s);
	}

	public String readFile(String fileName) {

		Scanner sc = null;
		StringBuilder sb = null;
		String thisLine;
		try {
			sc = new Scanner(new FileInputStream(fileName));
			sb = new StringBuilder();
			while (sc.hasNextLine()) {
				thisLine = sc.nextLine();
				sb.append(thisLine);
				sb.append("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("OH NO THEY KILLED KENNY");
		} finally {
			sc.close();
		}
		return sb.toString();
	}

public Course[] breakFile(String File) {
		StringTokenizer st = new StringTokenizer(File, "\n");
		String[] lines = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			lines[i] = st.nextToken();
			// System.out.println(lines[i]);
			i++;

		}
		int size = lines.length;
		String[][] LineOne = new String[size][3];
		String[][] LineTwo = new String[size][2];
		String[][] LineThree = new String[size][2];
		for (int j = 0; j < lines.length; j++) {
			StringTokenizer sb = new StringTokenizer(lines[j], "\t");
			int k = 0;
			if (j % 3 == 0) {
				while (sb.hasMoreTokens()) {
					LineOne[j][k] = sb.nextToken();
					//System.out.println(LineOne[j][k]);
					// System.out.println("------");
					k++;
				}
			}
			if (j % 3 == 1) {
				while (sb.hasMoreTokens()) {
					LineTwo[j][k] = sb.nextToken();
					//System.out.println(LineTwo[j][k]);
					// System.out.println("------");
					k++;
				}
			}
			if (j % 3 == 2) {
				while (sb.hasMoreTokens()) {
					LineThree[j][k] = sb.nextToken();
					//System.out.println(LineThree[j][k]);
					// System.out.println("------");
					k++;
				}
			}



		}
		Course[] courses = new Course[lines.length/3];
double[] credits = new double[(lines.length/3)];
int count = 0;
for(int p=0;p<lines.length;p+=3){
credits[count]=Double.parseDouble(LineOne[p][2]);
//System.out.println(credits[count]);
count++;
}
count=0;
for (int p=0;p<lines.length; p+=3){
	courses[count] = new Course(LineOne[p][0],LineOne[p][1],credits[count],LineTwo[p+1][1],LineThree[p+2][1]);
	System.out.println(courses[count]);
	count++;
}


return courses;
	}

}

// Example of file to be read
// COMP108 Computer_Science_Industrial_Experience_Reflective_Learning_I 3
// P
// C
//
// COMP201 Introduction_to_Computing 3
// P MATH201
// C
//
// COMP208 Computer_Science_Industrial_Experience_Reflective_Learning_II 3
// P COMP108
// C
//
// COMP218 Fundamentals_of_Programming 3
// P MATH201
// C
//
// COMP248 Object-Oriented_Programming_I 3.5
// P MATH204
// C COMP201
//
// COMP228 System_Hardware 3
// P COMP248
// C
//
// COMP249 Object-Oriented_Programming_II 3.5
// P COMP248
// C
//
// COMP371 Computer_Graphics 4
// P COMP248
// C COMP249
//
// COMP376 Introduction_to_Game_Development 4
// P COMP371
// C COMP371
//
// COMP228 System_Hardware 3
// P COMP248
// C
