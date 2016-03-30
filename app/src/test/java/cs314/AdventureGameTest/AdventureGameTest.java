/* AdventureGameTest class: tests the methods written in cs314_A3.AdventureGame class
 * 
 * Tests for correctness of: getPlayer, startQuest, Main()
 * 
 * 	Unable to test 	private int convertDirection(char input)
 *					private Item choosePickupItem(Player p,  BufferedReader keyB)
 *					private int chooseDropItem(Player p,  BufferedReader keyB)
 * 
 * @authors
 * Zach Fuller
 * Josh Foley
 * Jason Ritzman
 * 
 * Updated March 9 2016 
 * - Implemented black box and white box tests
 * */

package AdventureGameTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import AdventureGame.AdventureGame;

public class AdventureGameTest {
	
	private AdventureGame test;
	
	/* setUp() - tests the constructors of the equivalences classes
	 * 			used by subsequent methods
	 * 		- Inputs domain: N/A, constructors are all default
	 * 		- Equivalence classes: AdventureGame
	 * 		- Boundary conditions: N/A, constructors are all default
	 */
	@Before
	public void setUp() throws IOException {
		test = new AdventureGame();
	}

	/* tearDown() - tests the constructors ability to nullify the
	 * 			equivalence classes used
	 * 		- Input domain: N/A
	 * 		- Equivalence classes: AdventureGame
	 * 		- Boundary conditions: N/A
	 */
	@After
	public void tearDown() {
		test = null;
		assertNull(test);		
	}
	
	/* testGetPlayer() - tests whether the getPlayer method returns a player
	 * properly
	 * 		- Input domains: AdventureGame
	 * 		- Equivalence classes: N/A
	 * 		- Boundary conditions: N/A
	 */
	@Test
	public void testGetPlayer() {
		// WB Test
		assertNotNull(test.getPlayer());
	}
	
	/* testStartQuest() - tests whether the startQuest method sets up correctly
	 * 		- Input domains: AdventureGame
	 * 		- Equivalence classes: N/A
	 * 		- Boundary conditions: N/A
	 */
	@Test
	public void testStartQuest() throws IOException {
		test.startQuest();
		// WB Test
		assertNotNull(test);
	}
	
	/* testMain() - tests whether the Main method runs correctly
	 * 		- Input domains: AdventureGame
	 * 		- Equivalence classes: N/A
	 * 		- Boundary conditions: N/A
	 */
	@Test
	public void testMain() throws IOException { 
		AdventureGame.main(new String[] { "a", "b" });
		// WB Test
		assertNotNull(test);
	}
}
