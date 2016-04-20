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
Updated April 17 2016
- added some functionality to drop and grab
Updated April 18 2016
- added difficulty setting in constructor

**/

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class AdventureGameModelFacade {

 // some private fields to reference current location,
 // its description, what I'm carrying, etc.
 //
 // These methods and fields are left as exercises.
 
 //The game we are playing
	private String roomDesc = "";
	public String message = "";

	Player thePlayer = new Player();
	Adventure theCave = new Adventure();

//CONSTRUCTOR
  public AdventureGameModelFacade(int difficulty) throws IOException { // we initialize
	  theCave.setDifficulty(difficulty);
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
	  roomDesc = thePlayer.look();
	  if (thePlayer.handsFull()){
		  roomDesc+="\nYour hand are full!";
	  } else
		try {
			itemToGrab = choosePickupItem(thePlayer,itemNum);
			if(itemToGrab!=null){
		    	thePlayer.pickUp(itemToGrab);
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
	  System.out.println(contentsArray.length);
	  System.out.println(keyB);
	  if(contentsArray.length == 0){
		  return null;
	  }
	  else if (contentsArray.length < keyB){
		  p.getLoc().removeItem(contentsArray[keyB-2]);
		  return contentsArray[keyB-2];
	  }
	  p.getLoc().removeItem(contentsArray[keyB-1]);
	 // System.out.println(contentsArray.length);
	  return contentsArray[keyB-1];

}

}
