/* AdventureTest class: tests the methods written in cs314_A3.Adventure class
 * 
 * Tests for correctness of: goUp, goDown, goNorth, goSouth, goEast, goWest
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

import cs314_A3.Adventure;
import cs314_A3.Item;
import cs314_A3.Player;
import cs314_A3.Room;

public class AdventureTest {

	private Adventure theCave;
	private String roomDesc;
	private Player thePlayer;
	private Room outside;
	private Room r1;
	private Room r2;
	private Room r3;
	private Room r4;
	private Room r5;
	private Room r6;
	private Room r7;
	private Room r8;
	private Room r9;
	private Room r10;
	private Room r11;
	
	/* setUp() - tests the constructors of the equivalences classes
	 * 			used by subsequent methods
	 * 		- Inputs domain: N/A, constructors are all default
	 * 		- Equivalence classes: Adventure, Player, String, Room
	 * 		- Boundary conditions: N/A, constructors are all default
	 */
	@Before
	public void setUp() {
		Adventure theCave = new Adventure();
		outside = theCave.createAdventure();
		thePlayer = new Player();
		thePlayer.setRoom(outside);
		roomDesc = thePlayer.look();
		assertNotNull(theCave);
		assertNotNull(outside);
		thePlayer.go(5);
		r1 = thePlayer.getLoc();
		thePlayer.go(2);
		r2 = thePlayer.getLoc();
		thePlayer.go(2);
		r3 = thePlayer.getLoc();
		thePlayer.go(2);
		r4 = thePlayer.getLoc();
		thePlayer.setLoc(r3);
		thePlayer.go(5);
		r5 = thePlayer.getLoc();
		thePlayer.go(2);
		r6 = thePlayer.getLoc();
		Item[] contentsArray = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray[0]);
		thePlayer.setLoc(r4);
		thePlayer.go(5);
		r7 = thePlayer.getLoc();
		thePlayer.setLoc(r4);
		thePlayer.go(0);
		r8 = thePlayer.getLoc();
		thePlayer.go(3);
		r9 = thePlayer.getLoc();
		thePlayer.setLoc(r8);
		thePlayer.go(2);
		r10 = thePlayer.getLoc();
		thePlayer.go(5);
		r11 = thePlayer.getLoc();
		
		thePlayer.setLoc(r6);
		thePlayer.drop(1);
		thePlayer.setLoc(outside);
	}
	
	/* tearDown() - tests the constructors ability to nullify the
	 * 			equivalence classes used
	 * 		- Input domain: N/A
	 * 		- Equivalence classes: Adventure, Player, String, Room
	 * 		- Boundary conditions: N/A
	 */
	@After
	public void tearDown() {
		thePlayer = null;
		theCave = null;
		outside = null;
		roomDesc = null;
		assertNull(thePlayer);
		assertNull(theCave);
		assertNull(outside);
		assertNull(roomDesc);
	}

	/* testGo*IntoWall() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoUpIntoWall() {
		thePlayer.setLoc(outside);
		thePlayer.go(4);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(outside, thePlayer.getLoc());
		assertEquals(outside.getDesc(), roomDesc);
	}
	
	/* testGo*IntoWall() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoDownIntoWall() {
		thePlayer.setLoc(r1);
		thePlayer.go(5);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r1, thePlayer.getLoc());
		assertEquals(r1.getDesc(), roomDesc);
	}

	/* testGo*IntoWall() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoNorthIntoWall() {
		thePlayer.setLoc(outside);
		thePlayer.go(0);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(outside, thePlayer.getLoc());
		assertEquals(outside.getDesc(), roomDesc);
	}
	
	/* testGo*IntoWall() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoSouthIntoWall() {
		thePlayer.setLoc(outside);
		thePlayer.go(1);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(outside, thePlayer.getLoc());
		assertEquals(outside.getDesc(), roomDesc);
	}
	
	/* testGo*IntoWall() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoEastIntoWall() {
		thePlayer.setLoc(outside);
		thePlayer.go(2);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(outside, thePlayer.getLoc());
		assertEquals(outside.getDesc(), roomDesc);
	}
	
	/* testGo*IntoWall() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoWestIntoWall() {
		thePlayer.setLoc(outside);
		thePlayer.go(3);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(outside, thePlayer.getLoc());
		assertEquals(outside.getDesc(), roomDesc);
	}
	
	/* testGo*IntoAdjacentRoom() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoUpIntoAdjacentRoom() {
		thePlayer.setLoc(r1);
		thePlayer.go(4);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(outside, thePlayer.getLoc());
		assertEquals(outside.getDesc(), roomDesc);
	}
	
	/* testGo*IntoAdjacentRoom() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoDownIntoAdjacentRoom() {
		thePlayer.setLoc(outside);
		thePlayer.go(5);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r1, thePlayer.getLoc());
		assertEquals(r1.getDesc(), roomDesc);
	}
	
	/* testGo*IntoAdjacentRoom() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoNorthIntoAdjacentRoom() {
		thePlayer.setLoc(r4);
		thePlayer.go(0);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r8, thePlayer.getLoc());
		assertEquals(r8.getDesc(), roomDesc);
	}
	
	/* testGo*IntoAdjacentRoom() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoSouthIntoAdjacentRoom() {
		thePlayer.setLoc(r8);
		thePlayer.go(1);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r4, thePlayer.getLoc());
		assertEquals(r4.getDesc(), roomDesc);
	}
	
	/* testGo*IntoAdjacentRoom() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoEastIntoAdjacentRoom() {
		thePlayer.setLoc(r1);
		thePlayer.go(2);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r2, thePlayer.getLoc());
		assertEquals(r2.getDesc(), roomDesc);
	}
	
	/* testGo*IntoAdjacentRoom() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoWestIntoAdjacentRoom() {
		thePlayer.setLoc(r2);
		thePlayer.go(3);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r1, thePlayer.getLoc());
		assertEquals(r1.getDesc(), roomDesc);
	}
	
	/* testGoDownIntoDoorWithoutKey() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Without Key
	 */
	@Test
	public void testGoDownIntoDoorWithoutKey() {
		thePlayer.setLoc(r10);
		thePlayer.go(5);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r10, thePlayer.getLoc());
		assertEquals(r10.getDesc(), roomDesc);
	}

	/* testGoDownIntoDoorWithKey() - tests whether the go(int) method sets the players
	 * location properly
	 * 		- Input domains: Player, Room
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: With Key
	 */
	@Test
	public void testGoDownIntoDoorWithKey() {
		thePlayer.setLoc(r6);
		Item[] contentsArray = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray[0]);
		thePlayer.setLoc(r10);
		thePlayer.go(5);
		roomDesc = thePlayer.look();
		// BB Test
		assertEquals(r11, thePlayer.getLoc());
		assertEquals(r11.getDesc(), roomDesc);
	}
	
	/* testCreateAdventure() - tests whether the constructor functions correctly
	 * 		- Input domains: N/A
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: N/A
	 */
	@Test
	public void testCreateAdventure() {
		// WB Test
		assertNotNull(outside);
	}
}
