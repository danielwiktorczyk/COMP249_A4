import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class EnrolmentResults {

private static void pause(Scanner userIn) {
		System.out.println("\nAdvance code? Hit enter");
		userIn.nextLine();
	}
public static void Request(Syllabus List,Scanner userIn) {
		System.out.println("Please enter the name of the request file you'd like to submit");
		Scanner sc = new Scanner(System.in);
		String thisLine;
		StringBuilder sb=null;
		String answer = sc.nextLine();
		try {
			sc = new Scanner(new FileInputStream(answer));
			sb = new StringBuilder();
			while (sc.hasNextLine()) {
				thisLine = sc.nextLine();
				sb.append(thisLine);
				sb.append("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Check your files, you've left something missing");
			System.exit(0);
		} finally {
			sc.close();
		}
		String Request = sb.toString();
		StringTokenizer st = new StringTokenizer(Request, "\n");
		ArrayList<String> Finished = new ArrayList<String>();
		ArrayList<String> Requested = new ArrayList<String>();
		boolean flip = false;
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			if (temp.equals("Requested")) {
				flip = true;
			}
			if (flip == false && temp.equals("Finished") ==false) {
				Finished.add(temp);
			}
			else 
				if (temp.equals("Requested")==false && temp.equals("Finished") ==false)
				Requested.add(temp);
		}		
		for (int i=0; i<Requested.size();i++) {
			CourseList tempList = List.getList();
			 Course tempCourse =tempList.find(Requested.get(i)).course;
			 System.out.println(tempCourse);
			boolean coreqs = false;
			boolean prereqs = false;
			if (Finished.contains(tempCourse.getpreReqID()) || tempCourse.getpreReqID() == ""){
				prereqs = true;
			}
			if (Finished.contains(tempCourse.getcoReqID()) || Requested.contains(tempCourse.getcoReqID()) || tempCourse.getcoReqID()== "") {
				coreqs = true;
			}
			if (coreqs == true && prereqs == true) {
				if (tempCourse.getcoReqID() == "" && tempCourse.getpreReqID() == "")
					System.out.println("Sucessful Enrollment into " + tempCourse.getCourseID()); 
					else 
				if (tempCourse.getcoReqID() == "" && tempCourse.getpreReqID() != "") {
						System.out.println("Sucessful Enrollment into " + tempCourse.getCourseID() + " due to enrollment in coreq: " + tempCourse.getcoReqID());
					}
				if (tempCourse.getcoReqID() != "" && tempCourse.getpreReqID() == "") {
					System.out.println("Sucessful Enrollment into " + tempCourse.getCourseID() + " due to previous completion of prequisite: " + tempCourse.getpreReqID());
				}
				if (tempCourse.getcoReqID() != "" && tempCourse.getpreReqID() != "") {
					System.out.println("Sucessful Enrollment into " + tempCourse.getCourseID() + " due to previous completion of prequisite: " + tempCourse.getpreReqID() +" and current enrollment in the coreq " + tempCourse.getcoReqID());
				}
			}
			else
				System.out.println("Student can't enroll in " + tempCourse.getCourseID() +  " as he/she doesn't have sufficient background needed");
			
		}
		// part d
		// prompt user for courseIDs, search list, display iterations
		System.out.println("================================================");
			pause(userIn);
		System.out.println("PART D : ");
		System.out.println("================================================");
		System.out.println("Please enter the name of the course you'd like to search the request file for");
			String Search = userIn.nextLine();
			if(Finished.contains(Search)||Requested.contains(Search)) {
				System.out.println("The request file contains the course you're looking for");
			}
			else
			System.out.println("The request file doesn't contains the course you're looking for");
		System.out.println("================================================");
		pause(userIn);
}


public static void main(String[] args) {

		Scanner userIn = new Scanner(System.in);

		// part a
		// two empty course lists
		System.out.println("PART A : ");
		System.out.println("================================================");
		CourseList cl1 = new CourseList();
		CourseList cl2 = new CourseList();
		cl1.display();
		cl2.display();
		System.out.println("================================================");
		pause(userIn);

		// part b
		// syllabus file
		System.out.println("PART B : ");
		System.out.println("================================================");
		Syllabus List = new Syllabus("Syllabus.txt");
		System.out.println("================================================");
		pause(userIn);

		// part c
		// open a request file
		System.out.println("PART C : ");
		System.out.println("================================================");
					Request(List,userIn);
	//	System.out.println("================================================");
		//pause(userIn);

		// part d
		// prompt user for courseIDs, search list, display iterations
		//System.out.println("PART D : ");
		//System.out.println("================================================");

		//System.out.println("================================================");
		//pause(userIn);

		// part e
		// test constructors/methods of classes
		System.out.println("PART E : ");
		System.out.println("================================================");
		
		System.out.println("Making a new course list as follows, into ecL:");
		Course ec1 = new Course("ARTS446", "It's the arts", 4, "ARTS244", "ORGN412");
		Course ec2 = new Course("TECH336", "Bits and Bites", 3, "TECH222", "");
		Course ec3 = new Course("ARTS412", "Art of origami", 4, "ARTS244", "ARTS446");
		Course ec4 = new Course("ARTS512", "Advanced art", 6, "ARTS446", "");
		Course ec5 = new Course("ARTS532", "Advanced art", 6, "ARTS446", "");
		CourseList ecL = new CourseList();
		ecL.addToStart(ec1);
		ecL.addToStart(ec2);
		ecL.addToStart(ec3);
		ecL.display();

		pause(userIn);
		
		System.out.println("Copying this courselist into ecLPRIME");
		CourseList ecLPRIME = new CourseList(ecL);
		ecLPRIME.display();
		System.out.println("Contents of ecLPRIME (compare this to the previous)");
		
		pause(userIn);

		System.out.println("\nAdding ec4 to list at index 4....");
		ecL.insertAtIndex(ec4, 2);
		ecL.display();

		pause(userIn);

		System.out.println("ARTS412 is found within this course list ecL is : " + ecL.contains("ARTS412"));
		System.out.println("PIE345 is found within this course list ecL is : " + ecL.contains("PIE345"));

		// uncomment this to see what happens in the code!
		// System.out.println("\nAdding ec2 again to list at index 6....");
		// ecL.insertAtIndex(ec4, 6);
		// ecL.display();

		pause(userIn);

		System.out.println("Deleting element at index 3");
		ecL.deleteAtIndex(3);
		ecL.display();

		pause(userIn);

		System.out.println("Deleting element from start");
		ecL.deleteFromStart();
		ecL.display();

		pause(userIn);

		System.out.println("Deleting element from start, AGAIN");
		ecL.deleteFromStart();
		ecL.display();

		pause(userIn);

		System.out.println("Deleting element from start, AGAIN");
		ecL.deleteFromStart();
		ecL.display();

		pause(userIn);

		System.out.println("ec1.equals(ec2) is " + ec1.equals(ec2));
		System.out.println("ec4.equals(ec5) is " + ec4.equals(ec5));
		System.out.println("Cloning ec1 to ec6");
		Course ec6 = ec1.clone();
		System.out.println("ec1 is : " + ec1);
		System.out.println("ec6 (the clone of ec1) is : " + ec6);

		System.out.println("================================================");

		userIn.close();

	}

}

/*
 * Now, you are required to write a public class called EnrolmentResults. In the
 * main() method, you must do the following: (a) Create at least two empty lists
 * from the CourseList class (needed for copy constructor III (e)); (b) Open the
 * Syllabus.txt file, and read its contents line by line. Use these records to
 * initialize one of the CourseList objects you created above. You can use the
 * addToStart() method to insert the read objects into the list. However, the
 * list should not have any duplicate records, so if the input file has
 * duplicate entries, which is the case in the file provided with the assignment
 * for instance, your code must handle this case so that each record is inserted
 * in the list only once; (c) Open a Request.txt file (prompt the user to enter
 * the name of the file that need to be processed; i.e. Request3.txt) and create
 * ArrayLists from the contents then iterate through each of the courses the
 * student wants to enroll in. Process each of the courses and print the outcome
 * whether student will be able to enroll or not. A sample output for a given
 * file is mentioned below. Again, your program should ask for the file names as
 * your program will be tested against similar input files; (d) Prompt the user
 * to enter a few courseIDs and search the list that you created from the input
 * file for these values. Make sure to display the number of iterations
 * performed; (e) Following that, you must create enough objects to test each of
 * the constructors/methods of your classes. The details of this part are left
 * as open to you. You can do whatever you wish as long as COMP249 - Winter 2018
 * Assignment 4 - Page 5 of 6 your methods are being tested including
 */

