package adventuregame1;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main	
     
     class Door: Primary method, enter, determines whether
 	 a player has the correct key, myKey, to open the door
	 and move from the outside of the door (outSite) to the
	 inside of the door (inSite).
	 
	 Updated February 4 2016
	 - added project comments

     Updated April 18 2016
     - added boolean rusty, isRusty(), oiledDoor()
**/

/** 
 * @authors 
 * Zach Fuller
 * Josh Foley
 * Jason Ritzman
**/

// class Door

public class Door implements CaveSite {
  /** In this implementation doors are always locked.
      A player must have the correct key to get through
      a door.  Doors automatically lock after a player
      passes through. 
  **/
  
  /** Player must have this key to open the door */
  private Key myKey;

  /** Doors can be rusty, must have oil to pass through rusty doors */
  private boolean rusty;

  /** The door's location. */ 
  private CaveSite outSite;
  private CaveSite inSite;

  /** We can construct a door at the site. */
  public Door(CaveSite out, CaveSite in, Key k, boolean rusty){
    outSite = out;
    inSite = in;
    myKey = k;
    this.rusty = rusty;
  }

  /** Is the door rusty? */
  public boolean isRusty(){
      return this.rusty;
  }

  /** Oiled the door */
  public void oiledDoor(){
      this.rusty = false;
  }

 /** A player will need the correct key to enter. */
 public void enter(Player p) {
     if (isRusty()) {
         if (p.showMyThings().contains("Oily oil")) {
             System.out.println("You oiled the door!");
             oiledDoor();
         } else {
             if (p.haveItem(myKey)) {
                 System.out.println("Your key works! The door creaks open,");
                 System.out.println("and slams behind you after you pass through.");
                 if (p.getLoc() == outSite) inSite.enter(p);
                 else if (p.getLoc() == inSite) outSite.enter(p);
             } else {
                 System.out.println("You don't have the key for this door!");
                 System.out.println("Sorry.");
             }
         }
     }

     if (!isRusty()) {
         if (p.haveItem(myKey)) {
             System.out.println("Your key works! The door creaks open,");
             System.out.println("and slams behind you after you pass through.");
             if (p.getLoc() == outSite) inSite.enter(p);
             else if (p.getLoc() == inSite) outSite.enter(p);
         } else {
             System.out.println("You don't have the key for this door!");
             System.out.println("Sorry.");
         }
     }
 }
}

