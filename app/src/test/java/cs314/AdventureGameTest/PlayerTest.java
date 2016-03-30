/* PlayerTest class: tests the methods written in cs314_A3.Player class
 * 
 * Tests for correctness of: Player constructor, setRoom, Look, Go, pickUp, 
 * haveItem, drop, setLoc, getLoc, showMyThings, showMyRoom, handsFull, 
 * handsEmpty, and numItemsCarried
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//EQUIVALENCE CLASSES
import cs314_A3.Adventure;
import cs314_A3.Item;
import cs314_A3.Player;
import cs314_A3.Room;

public class PlayerTest {
	
	private Player thePlayer = new Player();
	private Adventure theCave = new Adventure();
	private Room startRm = new Room();
	private Item i = new Item();
	private Item i2 = new Item();
	private Item i3 = new Item();
	
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

	/* testSetRoom() - tests whether the setRoom method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: r can be NULL or a Room, in this case startRm
	 */
	@Test
	public void testSetRoom() {
		//WB test
		assertNotNull(startRm);
		thePlayer.setLoc(startRm);
		//BB test
		assertEquals(startRm.getDesc(), thePlayer.getLoc().getDesc());
	}

	/* testLook() - tests whether look gets a String
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Room
	 * 		- Boundary conditions: N/A, nothing given to method as input 
	 */
	@Test
	public void testLook() {
		//BB test
		assertNotNull(thePlayer.look());
	}

	/* testGo() - tests whether method go moves the player to a new location
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Room
	 * 		- Boundary conditions: direction can be 0-5
	 */
	@Test
	public void testGo() {
		//BB test
		String before = thePlayer.look();
		thePlayer.go(5);
		String after = thePlayer.look();
		assertNotEquals(before, after);
	}

	/* testPickUp() - tests whether pickUp works and doesn't work
	 * when we have 2 items already
	 * 		- Input domains: Item
	 * 		- Equivalence classes: Player, Room
	 *		- Boundary conditions: Item can exist in the room or not
	 */
	@Test
	public void testPickUp() {
		//BB tests
		thePlayer.pickUp(i);
		thePlayer.pickUp(i2);
		assertTrue(thePlayer.haveItem(i));
		assertTrue(thePlayer.haveItem(i2));
		thePlayer.pickUp(i3);
		assertFalse(thePlayer.haveItem(i3));	
	}

	/* testHaveItem() - tests whether haveItem works when we do and don't
	 * have a particular item in our inventory
	 * 		- Input domains: Item, Player
	 * 		- Equivalence classes: Item
	 * 		- Boundary conditions: Item itemToFind either exists (residing
	 * in slot 1 or 2 of player inventory) or does not exist
	 */
	@Test
	public void testHaveItem() {
		//BB tests
		assertFalse(thePlayer.haveItem(i));
		thePlayer.pickUp(i);
		assertTrue(thePlayer.haveItem(i));
	}

	/* testDrop() - tests to see whether drop succeeded in dropping an item
	 * 		- Input domains: Int, Player, Item, Room
	 * 		- Equivalence classes: Item, Room
	 * 		- Boundary conditions: Any int, but only 1 or 2 will actually 
	 * drop an item
	 */
	@Test
	public void testDrop() {
		thePlayer.drop(3);
		thePlayer.pickUp(i);
		thePlayer.pickUp(i2);
		thePlayer.drop(2);
		//BB tests
		assertNotNull(thePlayer.myThings[1]);
		thePlayer.drop(1);
		assertNotNull(thePlayer.myThings[0]);
	}

	/* testSetLoc() - tests whether setLoc properly sets the player's location
	 * 		- Input domains: Room, Player
	 * 		- Equivalence classes: Room
	 * 		- Boundary conditions: Room r exists or does not
	 */
	@Test
	public void testSetLoc() {
		thePlayer.setLoc(startRm);
		//BB test
		assertNotNull(thePlayer.getLoc());
	}

	/* testGetLoc() - tests whether getLoc gets a location
	 * 		- Input domains: Player
	 * 		- Equivalence classes: Room
	 * 		- Boundary conditions: either Player has myLoc or it hasn't been set
	 */
	@Test
	public void testGetLoc() {
		//BB test
		assertNotNull(thePlayer.getLoc());	
	}

	/*  testShowMyThings() - tests to see if showMyThings gets a String
	 * 		- Input domains: Player
	 * 		- Equivalence classes: Item, String
	 * 		- Boundary conditions: Either Player has 0 items or 1-2 items
	 */
	@Test
	public void testShowMyThings() {
		//BB test
		assertNotNull(thePlayer.showMyThings());  
	}

	/* testShowMyRoom() - tests whether showMyRoom returns a string
	 * 		- Input domain: Player
	 * 		- Equivalence classes: Room, String
	 * 		- Boundary conditions: N/A no input given to method
	 */
	@Test
	public void testShowMyRoom() {
		//BB test
		assertNotNull(thePlayer.showMyRoom());
	}

	/* testHandsFull() - tests whether the handsFull works when a Player's hands
	 * are full and when they are not
	 * 		- Input domains: Player, Int
	 * 		- Equivalence classes: Item
	 * 		- Boundary conditions: If Player has less than 2 items or 2 or more 
	 */
	@Test
	public void testHandsFull() {
		//BB tests
		assertEquals(false, thePlayer.handsFull());
		thePlayer.pickUp(i);
		thePlayer.pickUp(i2);
		assertEquals(true, thePlayer.handsFull());
	}

	/* testHandsEmpty() - tests whether handsEmpty works when a Player's hands are
	 * full and when they are not
	 * 		- Input domain: Player, Int
	 * 		- Equivalence classes: Item
	 * 		- Boundary conditions: Player has 0 or more than 0 items
	 */
	@Test
	public void testHandsEmpty() {
		//BB tests
		assertEquals(true, thePlayer.handsEmpty());
		thePlayer.pickUp(i);
		assertEquals(false, thePlayer.handsEmpty());
	}

	/* testNumItemsCarried() - tests to make sure numItemsCarried returns an int
	 * 		- Input domain: Player
	 * 		- Equivalence classes: Item, Int
	 * 		- Boundary conditions: N/A no proper input given to method
	 */
	@Test
	public void testNumItemsCarried() {
		//BB tests
		assertNotNull(thePlayer.numItemsCarried());
	}

}
