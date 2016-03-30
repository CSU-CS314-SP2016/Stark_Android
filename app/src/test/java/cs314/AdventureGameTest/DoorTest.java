// Tests for the Door.java class


package cs314_A3Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314_A3.Adventure;
import cs314_A3.CaveSite;
import cs314_A3.Player;
import cs314_A3.Room;
import cs314_A3.Door;
import cs314_A3.Key;

public class DoorTest {
	private Player thePlayer = new Player();
	private Adventure theCave = new Adventure();
	private Room startRm;

	
	private Key myKey = new Key(); 
	
	private CaveSite outSite;
	private CaveSite inSite;
	
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
	@Test
	public void testDoor() {
		thePlayer.go(5); 
	}
	// Test for enter() method
	// A door is created with rooms on either side
	// if the player does not have the key the players location will remain the same
	// if the player has the key the players location should be different after execution
	@Test
	public void testEnter() {
		Door test = new Door(inSite, outSite, myKey);
		Room start = thePlayer.getLoc(); 
		test.enter(thePlayer);  
		assertEquals(start,thePlayer.getLoc());
		
		thePlayer.pickUp(myKey);
		test.enter(thePlayer);
		assertEquals(start,thePlayer.getLoc());
		
		Room in = new Room();
		Room out = new Room();
		Door test2 = new Door(in,out,myKey);
		thePlayer.setLoc(in);
		test2.enter(thePlayer);
		
		thePlayer.drop(0);
		test2.enter(thePlayer); 
	} 
   
}
