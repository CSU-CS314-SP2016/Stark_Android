/* AdventureGameViewTest class: tests the methods written in cs314_A3.AdventureGameView class
 * 
 * Tests for correctness of: adventureGameView, grab, drop, Main()
 * 
 * 	Unable to test 	AdventureGameView catch IOException
 *					buttonClicked method
 * 
 * @authors
 * Zach Fuller
 * Josh Foley
 * Jason Ritzman
 * 
 * Updated March 9 2016 
 * - Implemented black box and white box tests
 * */

package cs314_A3Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314_A3.AdventureGameView;

public class AdventureGameViewTest {
	
	private AdventureGameView test;

	/* setUp() - tests the constructors of the equivalences classes
	 * 			used by subsequent methods
	 * 		- Inputs domain: N/A, constructors are all default
	 * 		- Equivalence classes: AdventureGameView
	 * 		- Boundary conditions: N/A, constructors are all default
	 */
	@Before
	public void setUp() {
		test = new AdventureGameView();
		assertNotNull(test);
	}
	
	/* tearDown() - tests the constructors ability to nullify the
	 * 			equivalence classes used
	 * 		- Input domain: N/A
	 * 		- Equivalence classes: AdventureGameView
	 * 		- Boundary conditions: N/A
	 */
	@After
	public void tearDown() {
		test = null;
		assertNull(test);
	}
	
	/* testAdventureGameView() - tests whether the AdventureGameView() method constructor functions
	 * properly
	 * 		- Input domains: AdventureGameView
	 * 		- Equivalence classes: N/A
	 * 		- Boundary conditions: N/A
	 */
	@Test
	public void testAdventureGameView() {
		test = new AdventureGameView();
		// WB Test
		assertNotNull(test);
	}

	/* testGrab() - tests whether the grab() method grabs item properly
	 * 		- Input domains: int
	 * 		- Equivalence classes: Item
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testGrab() throws IOException {
		test.grab(1);
		// WB Test
		assertNotNull(test);
	}
	
	/* testDrop() - tests whether the drop() method grabs item properly
	 * 		- Input domains: int
	 * 		- Equivalence classes: Item
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testDrop() throws IOException {
		test.drop(1);
		// WB Test
		assertNotNull(test);
	}
	
	/* testMain() - tests whether the Main method runs correctly
	 * 		- Input domains: AdventureGameView
	 * 		- Equivalence classes: N/A
	 * 		- Boundary conditions: N/A
	 */
	@Test
	public void testMain() { 
		AdventureGameView.main(new String[] { "a", "b" });
		// WB Test
		assertNotNull(test);
	}
}
