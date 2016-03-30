/* class ItemTest: tests the methods written in class cs314_A3.Item
 * 
 * Tests for correctness of: Item constructor, setDesc, getDesc, and toString
 * 
 * @authors
 * Zach Fuller
 * Josh Foley
 * Jason Ritzman
 * 
 * Updated March 7 2016
 * - implemented method tests
 * 
 */

package cs314_A3Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//EQUIVALENCY CLASSES
import cs314_A3.Item;

public class ItemTest {
	
	Item i = new Item();
	String d = "test";

	/* testSetDesc() - tests whether setDesc properly sets an Item's description
	 * 		- Input domains: Item, String
	 * 		- Equivalence classes: String
	 * 		- Boundary domains: String d can be NULL or not NULL
	 */
	@Test
	public void testSetDesc() {
		i.setDesc(d);
		//BB test
		assertNotNull(i.getDesc());
	}

	/* testGetDesc() - tests whether getDesc properly gets an Item's description
	 * 		- Input domains: Item
	 * 		- Equivalence classes: String
	 * 		- Boundary domains: N/A no input given to method
	 */
	@Test
	public void testGetDesc() {
		i.setDesc(d);
		//BB test
		assertNotNull(i.getDesc());
	}

	/* testToString() - tests whether toString properly returns the desc as a string
	 * 	- Input domains: Item
	 * 	- Equivalence classes: String
	 * 	- Boundary conditions: N/A no input given to method
	 */
	@Test
	public void testToString() {
		i.setDesc(d);
		//BB test
		assertNotNull(i.toString());
	}

}
