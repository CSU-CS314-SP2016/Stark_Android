package cs314_A3Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)
@SuiteClasses({ AdventureGameModelFacadeTest.class, AdventureGameTest.class, AdventureGameViewTest.class, AdventureTest.class, CaveSiteTest.class, 
				DoorTest.class, ItemTest.class, KeyTest.class, PlayerTest.class, RoomTest.class, TreasureTest.class, WallTest.class})
public class AllTests {
	//Execution begins at main(). In this test class, we will execute
	//a text test runner that will tell you if any of your test fail
	public static void main(String[] args)
	{
		//junit.awtui.TestRunner.run(suite());
		//junit.swingui.TestRunner.run(suite());
		junit.textui.TestRunner.run(suite());
	}
	
	//The suite() method is helpful when using JUnit 3 Test Runner or Ant.
	public static junit.framework.Test suite()
	{ 
		return new JUnit4TestAdapter(AllTests.class);
	}
}
