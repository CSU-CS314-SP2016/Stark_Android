package adventuregame1;

/**  Adventure Game  Program Code
Copyright (c) 1999 James M. Bieman

To compile: javac AdventureGame.java
To run:     java AdventureGame

The main routine is AdventureGame.main	

class AdventureGameModelFacade: Links game model with GUI
and AdventureGame

Updated February 4 2016
- added project comments
Updated Feburary 17 2016
- implemented all stub methods for movement and item manipulation

**/

import java.io.IOException;

public class AdventureGameModelFacade {

 // some private fields to reference current location,
 // its description, what I'm carrying, etc.
 //
 // These methods and fields are left as exercises.
 
 //The game we are playing
	private String roomDesc = "";
	public String message = "";

	Player thePlayer = new Player();

  public AdventureGameModelFacade() throws IOException { // we initialize
	  //Player thePlayer = new Player();
	  Adventure theCave = new Adventure();
	  Room startRm = theCave.createAdventure();
	  thePlayer.setRoom(startRm);
	  roomDesc = thePlayer.look();
}

  public void goUp(){
	  thePlayer.go(4);
	  roomDesc = thePlayer.look();
  }

  public void goDown(){
	  thePlayer.go(5);
	  roomDesc = thePlayer.look();
  }

  public void goNorth(){
	  thePlayer.go(0);
	  roomDesc = thePlayer.look();
  }
      
  public void goSouth(){
	  thePlayer.go(1);
	  roomDesc = thePlayer.look();
  }

  public void goEast(){
	  thePlayer.go(2);
	  roomDesc = thePlayer.look();
	  getView();
  }
      
  public void goWest(){
	  thePlayer.go(3);
	  roomDesc = thePlayer.look();
  }
  
  public void grab(int itemNum){
	  Item itemToGrab;
	try {
		itemToGrab = choosePickupItem(thePlayer,itemNum);
		if(itemToGrab!=null){
		    thePlayer.pickUp(itemToGrab);
		    roomDesc = thePlayer.look();
		    roomDesc+="\nYou grabbed " + itemToGrab.toString() + ".";
		}
		else{
			roomDesc+="\nNo item to grab.";
		}
	} catch (IOException e) {
		e.printStackTrace();
	}  

      
  }
  
  public void drop(int itemNum){
	   if (thePlayer.numItemsCarried() == 0){
		   roomDesc+="\nNo items to drop.";
		   return;
	   }
	   if (itemNum == 2 && thePlayer.numItemsCarried() == 1){
			   roomDesc+="\nNo 2nd item to drop.";
			   return;
		   }
	   thePlayer.drop(itemNum);
	   roomDesc = thePlayer.look();
	   if (itemNum == 1){
		   roomDesc+="\nDropped 1st item.";
	   } else if (itemNum == 2){
		   roomDesc+="\nDropped 2nd item.";
	   }
  }
  
  // You need to finish these getView and getItems methods.
  public String getView(){ 
	  return roomDesc + "\n" + message;
  }

  public String getItems(){
     return thePlayer.showMyThings();
  }
  
  private Item choosePickupItem(Player p,  int keyB) throws IOException{
	  Item[] contentsArray = (p.getLoc()).getRoomContents(); 
	 // System.out.println(contentsArray.length);
	  if(contentsArray.length == 0){
		  return null;
	  }
	  p.getLoc().removeItem(contentsArray[keyB-1]);
	 // System.out.println(contentsArray.length);
	  return contentsArray[keyB-1];

}

}
