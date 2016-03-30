package cs314_A3Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314_A3.Adventure;
import cs314_A3.Player;
import cs314_A3.Room;
import cs314_A3.CaveSite;

public class CaveSiteTest {
	private Player thePlayer = new Player();
	private Adventure theCave = new Adventure();
	private Room startRm;
	CaveSite test;
	
	/* setUp() - tests the constructors of the equivalences classes
	 * 			used by subsequent methods
	 * 		- Inputs domain: N/A, constructors are all default
	 * 		- Equivalence classes: Room, Adventure
	 * 		- Boundary conditions: N/A, constructors are all default
	 */
	@Before
	public void setUp() throws Exception {
		startRm = theCave.createAdventure();
		thePlayer.setRoom(startRm);
	}

	/* tearDown() - tests the constructors ability to nullify the
	 * 			equivalence classes used
	 * 		- Input domain: N/A
	 * 		- Equivalence classes: Room, Adventure
	 * 		- Boundary conditions: N/A
	 */
	@After
	public void tearDown() throws Exception {
		thePlayer = null;
		theCave = null; 
		startRm = null;
		assertNull(thePlayer);
		assertNull(theCave);
		assertNull(startRm);		  
	}
	
	// test to see that enter() changed the location of the player
	// Players location is set and then the enter is called the location should be different
	// than the original location
	@Test
	public void testEnter() {
		Room start = thePlayer.getLoc();
		Room end = thePlayer.getLoc();
		end.enter(thePlayer);
 
		assertEquals(start,thePlayer.getLoc()); 
	} 

}
