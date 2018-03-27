
public class CourseList {

	public class CourseNode {

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
 * constructor; v. A clone() method; vi. Other mutator and accessor methods. (b)
 * A private attribute called head, which should point to the first node in this
 * list object; (c) A private attribute called size, which always indicates the
 * current size of the list (how many nodes are in the list); (d) A default
 * constructor, which creates an empty list; (e) A copy constructor, which
 * accepts a CourseList object and creates a copy of it; (f) A method called
 * addToStart(), which accepts one parameter, an object from Course class and
 * then creates a node with that passed object and inserts this node at the head
 * of the list; (g) A method called insertAtIndex(), which accepts two
 * parameters, an object from Course class, and an integer representing an
 * index. If the index is not valid (a valid index must have a value between 0
 * and size-1), the method must throw a NoSuchElementException and terminate the
 * program. If the index is valid, then the method creates a node with the
 * passed Course object and inserts this node at the given index. The method
 * must properly handle all special cases; (h) A method called
 * deleteFromIndex(), which accepts one integer parameter representing an index.
 * Again, if the index is not valid, the method must throw a
 * NoSuchElementException and terminate the program. Otherwise; the node pointed
 * by that index is deleted from the list. The method must properly handle all
 * special cases; (i) A method called deleteFromStart(), which deletes the first
 * node in the list (the one pointed by head). All special cases must be
 * properly handled. (j) A method called replaceAtIndex(), which accepts two
 * parameters, an object from Course class, and an integer representing an
 * index. If the index is not valid, the method simply returns; otherwise the
 * object in the node at the passed index is to be replaced by the passed
 * object; (k) A method called find(), which accepts one parameter of type
 * String representing a courseID. The method then searches the list for a
 * courseNode with with that courseID. If such an object is found, then the
 * method returns a pointer to that courseNode; otherwise, method returns null.
 * The method must keep track of how many iterations were made before the search
 * finally finds the course or concludes that it is not in the list; (l) A
 * method called contains(), which accepts one parameter of type String
 * representing a courseID. The method returns true if a course with that
 * courseID is in the list; otherwise, the method returns false; (m) A method
 * called equals(), which accepts one parameter of type Syllabus. The method
 * returns true if the two lists contain similar courses; otherwise the method
 * returns false. Recall that two Course objects are equal if they have the same
 * values with the exception of the courseID, which can, and actually is
 * expected to be, different.
 * 
 */