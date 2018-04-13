
// -----------------------------------------------------
// Assignment 4
// Written by: Waqar Qureshi - 40055526 and Daniel Wiktorczyk - 40060894
// -----------------------------------------------------

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
 * Created from the syllabus file by interpreting it and saving the contained courses into an array
 */
public class Syllabus {

	private Course[] courses;
	private CourseList coursesList;

	public Syllabus(String fileName) {

		String s = readFile(fileName);
		courses = null;
		// System.out.println(s);
		courses = breakFile(s);
		coursesList = new CourseList();
		for (int i = courses.length - 1; i >= 0; i--) {
			if (coursesList.contains(courses[i].getCourseID()) == false)
				coursesList.addToStart(courses[i]);
		}
		coursesList.display();
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
			System.out.println("Check your files, you've left something missing");
			System.exit(0);
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
					// System.out.println(LineOne[j][k]);
					// System.out.println("------");
					k++;
				}
			}

			if (j % 3 == 1) {
				while (sb.hasMoreTokens()) {
					LineTwo[j][k] = sb.nextToken();
					// System.out.println(LineTwo[j][k]);
					// System.out.println("------");
					k++;
				}
			}

			if (j % 3 == 2) {
				while (sb.hasMoreTokens()) {
					LineThree[j][k] = sb.nextToken();
					// System.out.println(LineThree[j][k]);
					// System.out.println("------");
					k++;
				}
			}
		}
		Course[] courses = new Course[lines.length / 3];
		double[] credits = new double[(lines.length / 3)];
		int count = 0;
		for (int p = 0; p < lines.length; p += 3) {
			credits[count] = Double.parseDouble(LineOne[p][2]);
			count++;
		}
		count = 0;
		for (int p = 0; p < lines.length; p += 3) {
			courses[count] = new Course(LineOne[p][0], LineOne[p][1], credits[count], LineTwo[p + 1][1],
					LineThree[p + 2][1]);
			count++;
		}
		return courses;
	}

	public CourseList getList() {
		return this.coursesList;
	}
}
