
public class Course implements DirectlyRelatable, Cloneable {

	public Course(String courseID, String courseName, double credit, String preReqID, String coReqID) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.preReqID = preReqID;
		this.coReqID = coReqID;
	}

	private String courseID;
	private String courseName;
	private double credit;
	private String preReqID;
	private String coReqID;

	@Override
	public boolean isDirectlyRelated(Course C) {
		// TODO Auto-generated method stub
		return false;
	}

	public Course(Course otherCourse) {
		super(); // just template at the moment
		this.courseID = otherCourse.courseID;
		this.courseName = otherCourse.courseName;
		this.credit = otherCourse.credit;
		this.preReqID = otherCourse.preReqID;
		this.coReqID = otherCourse.coReqID;
	}

	/*
	 * Parameterized constructor that accepts five values and initializes courseID,
	 * courseName, credit, preReqID, coReqID to these passed values; b) Copy
	 * constructor, which takes in two parameters, a Course object and a String
	 * value. The newly created object will be assigned all the attributes of the
	 * passed object, with the exception of the courseID. courseID is assigned the
	 * value passed as the second parameter to the constructor. It is always assumed
	 * that this value will correspond to the unique courseID rule; c) clone()
	 * method. This method will prompt the user to enter a new courseID, then
	 * creates and returns a clone of the calling object with the exception of the
	 * courseID, which is assigned the value entered by the user; d) Additionally,
	 * the class should have a toString() and an equals() methods. Two courses are
	 * equal if they have the same attributes, with the exception of the courseID,
	 * which could be different. e) This class needs to implement the interface from
	 * part I. The method isDirectlyRelated that takes in another Course object C
	 * and should return true if C is pre-requisite or co-requisite of the current
	 * course object, or vise versa (hence the courses are directly related);
	 * otherwise it returns false.
	 */

}
