import java.util.NoSuchElementException;

public class CourseList implements Cloneable {

	/*
	 * Inner class, made private
	 */
	public class CourseNode {
		public Course course;
		public CourseNode next;

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
			this.next = otherNode.next; // this is bad, need to revisit
		}

		public CourseNode clone() {
			return new CourseNode(this);
		}
		public Course getCourse() {
			return course;
		}

	}

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
				end.next = new CourseNode(temp.course.clone(), null); // if the
																		// next
																		// element
																		// exists,
																		// make
																		// a new
																		// one
																		// and
																		// have
																		// end
																		// point
																		// to it
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

	public boolean deleteAtIndex(int index) throws NoSuchElementException {
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

/*
 * The CourseList class has the following:
 * 
 * (a) An inner class called CourseNode. This class has the following: i. Two
 * private attributes: an object of Course and a pointer to a CourseNode object;
 * ii. A default constructor, which assigns both attributes to null; iii. A
 * parameterized constructor that accepts two parameters, a Course object and a
 * CourseNode object, then initializes the attributes accordingly; iv. A copy
 * constructor; v. A clone() method; vi. Other mutator and accessor methods.
 * 
 * (b) A private attribute called head, which should point to the first node in
 * this list object;
 * 
 * (c) A private attribute called size, which always indicates the current size
 * of the list (how many nodes are in the list);
 * 
 * (d) A default constructor, which creates an empty list;
 * 
 * (e) A copy constructor, which accepts a CourseList object and creates a copy
 * of it;
 * 
 * (f) A method called addToStart(), which accepts one parameter, an object from
 * Course class and then creates a node with that passed object and inserts this
 * node at the head of the list;
 * 
 * (g) A method called insertAtIndex(), which accepts two parameters, an object
 * from Course class, and an integer representing an index. If the index is not
 * valid (a valid index must have a value between 0 and size-1), the method must
 * throw a NoSuchElementException and terminate the program. If the index is
 * valid, then the method creates a node with the passed Course object and
 * inserts this node at the given index. The method must properly handle all
 * special cases;
 * 
 * (h) A method called deleteFromIndex(), which accepts one integer parameter
 * representing an index. Again, if the index is not valid, the method must
 * throw a NoSuchElementException and terminate the program. Otherwise; the node
 * pointed by that index is deleted from the list. The method must properly
 * handle all special cases;
 * 
 * (i) A method called deleteFromStart(), which deletes the first node in the
 * list (the one pointed by head). All special cases must be properly handled.
 * 
 * (j) A method called replaceAtIndex(), which accepts two parameters, an object
 * from Course class, and an integer representing an index. If the index is not
 * valid, the method simply returns; otherwise the object in the node at the
 * passed index is to be replaced by the passed object;
 * 
 * (k) A method called find(), which accepts one parameter of type String
 * representing a courseID. The method then searches the list for a courseNode
 * with with that courseID. If such an object is found, then the method returns
 * a pointer to that courseNode; otherwise, method returns null. The method must
 * keep track of how many iterations were made before the search finally finds
 * the course or concludes that it is not in the list;
 * 
 * (l) A method called contains(), which accepts one parameter of type String
 * representing a courseID. The method returns true if a course with that
 * courseID is in the list; otherwise, the method returns false;
 * 
 * (m) A method called equals(), which accepts one parameter of type Syllabus.
 * The method returns true if the two lists contain similar courses; otherwise
 * the method returns false. Recall that two Course objects are equal if they
 * have the same values with the exception of the courseID, which can, and
 * actually is expected to be, different.
 * 
 */
