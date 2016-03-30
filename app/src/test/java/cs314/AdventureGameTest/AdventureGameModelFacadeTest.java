/* AdventureTest class: tests the methods written in cs314_A3.Adventure class
 * 
 * Tests for correctness of: goUp, goDown, goNorth, goSouth, goEast, goWest, grab, drop, getView
 * 
 * Unable to test catch IOException of grab method
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

import org.junit.After;

import java.io.IOException;

import AdventureGame.Adventure;
import AdventureGame.AdventureGameModelFacade;
import AdventureGame.Item;
import AdventureGame.Player;
import AdventureGame.Room;

public class AdventureGameModelFacadeTest {

	private AdventureGameModelFacade model;
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
	 * 		- Equivalence classes: AdventureGameModelFacade, Adventure, Player, String, Room
	 * 		- Boundary conditions: N/A, constructors are all default
	 */
	@Before
	public void setUp() throws IOException {
		model = new AdventureGameModelFacade();
		theCave = new Adventure();
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
	 * 		- Equivalence classes: AdventureGameModelFacade, Adventure, Player, String, Room
	 * 		- Boundary conditions: N/A
	 */
	@After
	public void tearDown() {
		model = null;
		theCave = null;
		thePlayer = null;
		roomDesc = null;
		outside = null;
		r1 = null;
		r2 = null;
		r3 = null;
		r4 = null;
		r5 = null;
		r6 = null;
		r7 = null;
		r8 = null;
		r9 = null;
		r10 = null;
		r11 = null;		
		assertNull(model);
		assertNull(theCave);
		assertNull(thePlayer);
		assertNull(roomDesc);
		assertNull(outside);
		assertNull(r1);
		assertNull(r2);
		assertNull(r3);
		assertNull(r4);
		assertNull(r5);
		assertNull(r6);
		assertNull(r7);
		assertNull(r8);
		assertNull(r9);
		assertNull(r10);
		assertNull(r11);
	}

	/* testGoUpIntoWall() - tests whether the goUp() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoUpIntoWall() {
		thePlayer.setLoc(outside);
		roomDesc = thePlayer.look();
		model.goUp();
		// BB Test
		assertEquals(model.getView(), roomDesc);
	}
	
	/* testGoDownIntoWall() - tests whether the goDown() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoDownIntoWall() {
		thePlayer.setLoc(r1);
		roomDesc = thePlayer.look();
		model.goDown();
		// BB Test
		assertEquals(model.getView(), roomDesc);
	}
	
	/* testGoNorthIntoWall() - tests whether the goNorth() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoNorthIntoWall() {
		thePlayer.setLoc(outside);
		roomDesc = thePlayer.look();
		model.goNorth();
		// BB Test
		assertEquals(model.getView(), roomDesc);
	}

	/* testGoSouthIntoWall() - tests whether the goSouth() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoSouthIntoWall() {
		thePlayer.setLoc(outside);
		roomDesc = thePlayer.look();
		model.goSouth();
		// BB Test
		assertEquals(model.getView(), roomDesc);
	}
	
	/* testGoEastIntoWall() - tests whether the goEast() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoEastIntoWall() {
		thePlayer.setLoc(outside);
		roomDesc = thePlayer.look();
		model.goEast();
		// BB Test
		assertEquals(model.getView(), roomDesc);
	}
	
	/* testGoWestIntoWall() - tests whether the goWest() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Wall
	 */
	@Test
	public void testGoWestIntoWall() {
		thePlayer.setLoc(outside);
		roomDesc = thePlayer.look();
		model.goWest();
		// BB Test
		assertEquals(model.getView(), roomDesc);
	}

	/* testGoUpIntoAdjacentRoom() - tests whether the goUp() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoUpIntoAdjacentRoom() {
		thePlayer.setLoc(r1);
		model.goUp();
		// BB Test
		assertEquals(outside.getDesc(), model.getView());
	}
	
	/* testGoDownIntoAdjacentRoom() - tests whether the goDown() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoDownIntoAdjacentRoom() {
		thePlayer.setLoc(outside);
		model.goDown();
		// BB Test
		assertEquals(r1.getDesc(), model.getView());
	}
	
	/* testGoNorthIntoAdjacentRoom() - tests whether the goNorth() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoNorthIntoAdjacentRoom() {
		thePlayer.setLoc(r4);
		model.goDown();
		model.goEast();
		model.goEast();
		model.goEast();
		model.goNorth();
		// BB Test
		assertEquals(r8.getDesc(), model.getView());
	}
	
	/* testGoSouthIntoAdjacentRoom() - tests whether the goSouth() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoSouthIntoAdjacentRoom() {
		thePlayer.setLoc(r8);
		model.goDown();
		model.goEast();
		model.goEast();
		model.goEast();
		model.goNorth();
		model.goSouth();
		// BB Test
		assertEquals(r4.getDesc(), model.getView());
	}
	
	/* testGoEastIntoAdjacentRoom() - tests whether the goEast() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoEastIntoAdjacentRoom() {
		thePlayer.setLoc(r1);
		model.goDown();
		model.goEast();
		// BB Test
		assertEquals(r2.getDesc(), model.getView());
	}
	
	/* testGoWestIntoAdjacentRoom() - tests whether the goWest() method sets the players
	 * location properly
	 * 		- Input domains: Player, Room, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure, Room
	 * 		- Boundary conditions: Adjacent Room
	 */
	@Test
	public void testGoWestIntoAdjacentRoom() {
		thePlayer.setLoc(r2);
		model.goDown();
		model.goEast();
		model.goWest();
		// BB Test
		assertEquals(r1.getDesc(), model.getView());
	}
	
	/* testGrabKey() - tests whether the grab() method gets theKey properly
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testGrabKey() {
		model.goDown();
		model.goEast();
		model.goEast();
		model.goDown();
		model.goEast();
		model.grab(1);
		thePlayer.setLoc(r6);
		Item[] contentsArray = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray[0]);
		// BB Test
		assertEquals(model.getItems(),thePlayer.showMyThings());
	}

	/* testGrabKeyAndTreasure() - tests whether the grab() method gets theKey the Treasure properly
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testGrabKeyAndTreasure() {
		model.goDown();
		model.goEast();
		model.goEast();
		model.goDown();
		model.goEast();
		model.grab(1);
		model.goWest();
		model.goUp();
		model.goEast();
		model.goNorth();
		model.goEast();
		model.goDown();
		model.grab(1);
		thePlayer.setLoc(r6);
		Item[] contentsArray1 = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray1[0]);
		thePlayer.setLoc(r11);
		Item[] contentsArray2 = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray2[0]);
		// BB Test
		assertEquals(model.getItems(),thePlayer.showMyThings());
	}
	
	/* testGrabNoItem() - tests whether the grab() method gets null properly
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testGrabNoItem() {
		model.grab(1);
		// BB Test
		assertEquals(model.getItems(),"");
	}
	
	/* testDropKey() - tests whether the drop() method drops theKey properly
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testDropKey() {
		model.goDown();
		model.goEast();
		model.goEast();
		model.goDown();
		model.goEast();
		model.grab(1);
		model.drop(1);
		// BB Test
		assertEquals(model.getItems(),"");
	}
	
	/* testDropNoItem() - tests whether the drop() method drops null properly
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testDropNoItem() {
		model.drop(1);
		// BB Test
		assertEquals(model.getItems(),"");
	}
	
	/* testDropNoSecondItem() - tests whether the drop() method drops no second item properly
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testDropNoSecondItem() {
		model.goDown();
		model.goEast();
		model.goEast();
		model.goDown();
		model.goEast();
		model.grab(1);
		model.drop(2);
		thePlayer.setLoc(r6);
		Item[] contentsArray = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray[0]);
		// BB Test
		assertEquals(model.getItems(),thePlayer.showMyThings());
	}
	
	/* testDropFirstItem() - tests whether the drop() method drops the first item properly while having 2 items
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testDropFirstItem() {
		model.goDown();
		model.goEast();
		model.goEast();
		model.goDown();
		model.goEast();
		model.grab(1);
		model.goWest();
		model.goUp();
		model.goEast();
		model.goNorth();
		model.goEast();
		model.goDown();
		model.grab(1);
		model.drop(1);
		thePlayer.setLoc(r6);
		Item[] contentsArray1 = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray1[0]);
		thePlayer.setLoc(r11);
		Item[] contentsArray2 = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray2[0]);
		thePlayer.drop(1);
		// BB Test
		assertEquals(model.getItems(),thePlayer.showMyThings());
	}
	
	/* testDropSecondItem() - tests whether the drop() method drops the second item properly while having 2 items
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testDropSecondItem() {
		model.goDown();
		model.goEast();
		model.goEast();
		model.goDown();
		model.goEast();
		model.grab(1);
		model.goWest();
		model.goUp();
		model.goEast();
		model.goNorth();
		model.goEast();
		model.goDown();
		model.grab(1);
		model.drop(2);
		thePlayer.setLoc(r6);
		Item[] contentsArray1 = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray1[0]);
		thePlayer.setLoc(r11);
		Item[] contentsArray2 = (thePlayer.getLoc()).getRoomContents();
		thePlayer.pickUp(contentsArray2[0]);
		thePlayer.drop(2);
		// BB Test
		assertEquals(model.getItems(),thePlayer.showMyThings());
	}
	
	/* testGetView() - tests whether the getView() method returns the correct room description
	 * 		- Input domains: Player, AdventureGameModelFacade
	 * 		- Equivalence classes: Adventure
	 * 		- Boundary conditions: theKey, Treasure, null
	 */
	@Test
	public void testGetView() {
		// WB Test
		assertNotNull(model.getView(), roomDesc);
	}
}
