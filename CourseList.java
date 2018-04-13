// -----------------------------------------------------
// Assignment 4
// Written by: Waqar Qureshi - 40055526 and Daniel Wiktorczyk - 40060894
// -----------------------------------------------------

import java.util.NoSuchElementException;

public class CourseList implements Cloneable {

	/*
	 * Inner class, made private
	 */
	public class CourseNode {
		private Course course;
		private CourseNode next;

		public Course getCourse() {
			return new Course (course, course.getCourseID());
		}
		
		/*
		 * Default constructor
		 */
		public CourseNode() {
			course = null;
			next = null;
		}

		/*
		 * Parameterized constructor
		 */
		public CourseNode(Course c, CourseNode node) {
			course = c;
			next = node;
		}

		/*
		 * Copy constructor (shallow)
		 */
		public CourseNode(CourseNode otherNode) {
			this.course = otherNode.course.clone();
			this.next = otherNode.next; // this is OK, 
			//because we cannot manipulate the contents of any course node (no set methods)
		}

		public CourseNode clone() {
			return new CourseNode(this);
		}

		/*
		 * PRIVACY LEAK !!!!
		 * See below method for explanation
		 */
//		public CourseNode getNext() {
//			return next;
//		}

		/*
		 * PRIVACY LEAK !!!!
		 * THIS GETTER is HORRIBLE as it can destroy a linked list!
		 */
//		public void setNext(CourseNode next) {
//			this.next = next;
//		}
//
//		public void setCourse(Course course) {
//			this.course = course;
//		}

	}

	/*
	 * 2 attributes
	 */
	private CourseNode head;
	private int size;

	/*
	 * Default Constructor
	 */
	public CourseList() {
		head = null;
		size = 0;
	}

	/*
	 * Copy Constructor
	 */
	public CourseList(CourseList otherList) {
		if (otherList == null)
			throw new NullPointerException();
		if (otherList.head == null)
			head = null;
		else {
			CourseNode temp = otherList.head; // Temporary pointer to the list
												// to be copied
			CourseNode newHead = new CourseNode(temp.course.clone(), null); // what
																			// will
																			// return
																			// to
																			// head
																			// eventually
			CourseNode end = newHead; // always points to end, so update all the
										// time
			temp = temp.next; // point to the second element in the original
								// array
			while (temp != null) {
				end.next = new CourseNode(temp.course.clone(), null);
				// if the next element exist, make a new one have it point to it
				end = end.next; // end points to the latest element
				temp = temp.next; // advance the temp scan on original array
				// rinse lather repeat!
			}
			head = newHead; // head now points to the head of the new list, deep
							// copied!
			size = otherList.size;
		}
	}

	public int getSize() {
		return size;
	}

	public boolean addToStart(Course c) {
		if (c == null)
			return false;
		head = new CourseNode(c, head);
		size++;
		return true;
	}

	public boolean insertAtIndex(Course c, int index) throws NoSuchElementException {
		if (c == null) {
			System.out.println("Was null");
			return false;
		}
		if (index < 0 || index > (size - 1))
			throw new NoSuchElementException();
		if (index == 0)
			addToStart(c);
		else {
			CourseNode indexedNode = head;
			for (int i = 0; i < (index - 1); i++) {
				indexedNode = indexedNode.next;
			}
			indexedNode.next = new CourseNode(c, indexedNode.next); // added
		}
		size++;
		return true;
	}

	public boolean deleteFromIndex(int index) throws NoSuchElementException {
		if (index < 0 || index > (size - 1))
			throw new NoSuchElementException();
		if (index == 0) {
			head = head.next;
		} else {
			CourseNode indexedNode = head;
			for (int i = 0; i < (index - 1); i++) {
				indexedNode = indexedNode.next;
			}
			indexedNode.next = indexedNode.next.next; // deleted element in the
														// middle
		}
		size--;
		return true;
	}

	public boolean deleteFromStart() {
		if (size == 0)
			return false;
		else {
			head = head.next;
			size--;
			return true;
		}
	}

	public CourseNode find(String c) {
		CourseNode tester = head;
		for (int i = 0; i < size; i++) {
			if (tester.course.getCourseID().equals(c))
				return tester;
			tester = tester.next;
		}
		return null;
	}
	
	//TODO 
	public void replaceAtIndex (Course c, int index) {
		//TODO!
	}

	public boolean contains(String c) {
		CourseNode tester = head;
		for (int i = 0; i < size; i++) {
			if (tester.course.getCourseID().equals(c))
				return true;
			tester = tester.next;
		}
		return false;
	}

	public boolean equals(Syllabus s) {
		//TODO!!!
		return false;
	}

	public void display() {
		System.out.print("This course list has");
		if (size == 0) {
			System.out.println(" no contents");
		} else {
			System.out.print(" " + (int) size + " courses. They are : \n");
			CourseNode iterator = head;
			for (int i = 0; i < size; i++) {
				System.out.println("\n " + (i + 1) + ":\n" + iterator.course.toString());
				iterator = iterator.next;
			}
		}
	}
}
