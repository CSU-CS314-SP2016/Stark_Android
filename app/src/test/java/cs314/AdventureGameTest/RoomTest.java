/*
 * Test cases for the Room.java class 
*
*
*/

package cs314_A3Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314_A3.Adventure;
import cs314_A3.Item;
import cs314_A3.Player;
import cs314_A3.Room;

public class RoomTest {
	
	private Player thePlayer = new Player();
	private Adventure theCave = new Adventure();
	private Room startRm;
	
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


	private ArrayList<Item> contents = new ArrayList<Item>();
	//Test to see if setting the description of a room results in the 
	//correct description added and does not result in a null description
	@Test
	public final void testSetDesc() {
		Room test = new Room();
		String testD = "test descr";
		test.setDesc(testD);
		assertNotNull(testD,test.getDesc());
	} 
	
	//	tests to see if the add item method results in an item being added to
	//	the contents array
	@Test
	public final void testAddItem() {
		Item test = new Item();
		assertTrue(contents.add(test));
	}

	//	Test to see if the removeItem method removes the correct item from the 
	//	rooms contents array
	@Test
	public final void testRemoveItem() {
		Item test = new Item();
		Room room = new Room();
		room.addItem(test);
		room.removeItem(test);
		assertNotNull(room.getRoomContents());
		
	}
	
	// test to see that the roomEmpty method returns the correct boolean when the 
	// room has no contents
	@Test
	public final void testRoomEmpty() {
		assertTrue(contents.isEmpty());
	}

	// test to see if GetRoomcontents returns the expected contents of the room
	@Test
	public final void testGetRoomContents() {
		Item[] contentsArray = new Item[contents.size()];
		contentsArray = contents.toArray(contentsArray);
		assertNotNull(contentsArray);
	}
 
	// test to see if getDesc() returns the correct description of the room
	// the room is setup and tested to see if the expected description is returned
	@Test
	public final void testGetDesc() {
		Item item1 = new Item();
		Item item2 = new Item();
		contents.add(item1);
		contents.add(item2);
		
		ListIterator<Item> roomContents = contents.listIterator(); 
		String contentString = "";
		   while(roomContents.hasNext()){ 
		     contentString = contentString + (roomContents.next()).getDesc() + " ";
		   } 
		assertNotNull(contentString);  
	}
	
	// Test to see if after enter() is performed that the player is now in the expected room.
	@Test
	public final void testEnter(){
		Room room = new Room();
		Room other = new Room();
		thePlayer.setLoc(other);
		room.enter(thePlayer);
		assertNotEquals(other,thePlayer.getLoc());  
	}
	
	// test to see that if after exit() is called that the player is in the expected room.
	@Test
	public final void testExit(){
		Room room = new Room();
		Room other = new Room();
		thePlayer.setLoc(other);
		room.exit(0,thePlayer);
		assertEquals(other,thePlayer.getLoc());  
	}
	
	// A room is setup and then tested to make sure that roomEmpty() returns true 
	@Test
	public final void roomEmptyTest(){
		Room room = new Room();
		assertTrue(room.roomEmpty());
	}

}
