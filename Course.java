
// -----------------------------------------------------
// Assignment 4
// Written by: Waqar Qureshi - 40055526 and Daniel Wiktorczyk - 40060894
// -----------------------------------------------------

import java.util.Scanner;

public class Course implements DirectlyRelatable, Cloneable {

	/*
	 * 
	 */
	public Course(String courseID, String courseName, double credit, String preReqID, String coReqID) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.preReqID = preReqID;
		this.coReqID = coReqID;
		if (preReqID == null)
			this.preReqID = "";
		if (coReqID == null)
			this.coReqID = "";
	}

	/*
	 * Add 5 attributes
	 */
	private String courseID;
	private String courseName;
	private double credit;
	private String preReqID;
	private String coReqID;

	@Override
	public boolean isDirectlyRelated(Course otherCourse) {
		// return true if C is pre-requisite or co-requisite of the current
		// course object, or vise versa (hence the courses are directly related)
		return (this.preReqID.equals(otherCourse.courseID) || this.coReqID.equals(otherCourse.courseID)
				|| otherCourse.preReqID.equals(this.courseID) || otherCourse.coReqID.equals(this.courseID));
	}

	public Course(Course otherCourse, String value) {
		super(); // just template at the moment
		this.courseID = value; // It is always assumed that this value will
								// correspond to the unique courseID rule
		this.courseName = otherCourse.courseName;
		this.credit = otherCourse.credit;
		this.preReqID = otherCourse.preReqID;
		this.coReqID = otherCourse.coReqID;
	}

	@SuppressWarnings("resource")
	public Course clone() {
		System.out.println("Enter a new course ID for the copy " + "of \"" + courseName + "\" you wish to clone");
		Scanner keys = new Scanner(System.in);
		String value = keys.next();
		// if value is the same course ID, then... ew
		// this is following the requirements, but needs to compare the given
		// course ID to a syllabus! Much more complicated
		return new Course(this, value);
	}

	public String toString() {
		return "\n   Course Name | " + courseName + "\n   Course ID | " + courseID + "\n   Credit    | " + credit
				+ "\n   Prereq ID | " + preReqID + "\n   Coreq ID  | " + coReqID;
	}

	public boolean equals(Course otherCourse) {
		return (this.courseName.equals(otherCourse.courseName) && this.credit == otherCourse.credit
				&& this.preReqID.equals(otherCourse.preReqID) && this.coReqID.equals(otherCourse.coReqID));
	}

	/*
	 * Getters n' Setters
	 */
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getPreReqID() {
		return preReqID;
	}

	public void setPreReqID(String preReqID) {
		this.preReqID = preReqID;
	}

	public String getCoReqID() {
		return coReqID;
	}

	public void setCoReqID(String coReqID) {
		this.coReqID = coReqID;
	}

}
