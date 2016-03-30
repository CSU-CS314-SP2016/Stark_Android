package cs314_A3Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs314_A3.Adventure;
import cs314_A3.Player;
import cs314_A3.Room;

public class WallTest {
	
	private Player thePlayer = new Player();
	private Adventure theCave = new Adventure();
	private Room startRm;
		
	@Before
	public void setUp() throws Exception {
		startRm = theCave.createAdventure();
		thePlayer.setRoom(startRm);
	}

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
	public void testEnter() {
		thePlayer.go(4);
	}

}
