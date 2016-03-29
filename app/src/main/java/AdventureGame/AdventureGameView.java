package AdventureGame;

/**  Adventure Game  Program Code
Copyright (c) 1999 James M. Bieman

To compile: javac AdventureGame.java
To run:     java AdventureGame

The main routine is AdventureGame.main	

class AdventureGameView: Primary method sets up an 
AdventureGameModelFacade and creates a GUI to play AdventureGame.
Also links buttons on GUI to model methods.

Updated February 4 2016
- added project comments
Updated Feburary 17 2016
- added 2nd drop and grab buttons to GUI and 
- implemented drop and grab methods with ints
**/

/** 
* @authors 
* Zach Fuller
* Josh Foley
* Jason Ritzman
**/

import java.io.IOException;

import javax.swing.*;


import BreezySwing.*;

public class AdventureGameView extends GBFrame{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// Window objects --------------------------------------
   JLabel welcomeLabel =
     addLabel("Welcome to the Adventure Game " + 
              "(inspired by an old game called the Colossal Cave Adventure)." +
            " Java implementation Copyright (c) 1999-2012 by James M. Bieman",
	    1,1,5,1);
   
   JLabel viewLable = addLabel ("Your View: ",2,1,1,1);
   JTextArea viewArea = addTextArea("Start",3,1,4,3); 

   JLabel carryingLable = addLabel ("You are carying: ",6,1,1,1);
   JTextArea carryingArea = addTextArea("Nothing",7,1,4,3); 

JLabel separator1 = addLabel
   ("-----------------------------------------------------------------"
	 , 10,1,4,1);


   JLabel choiceLabel    = addLabel
      ("Choose a direction, pick-up, or drop an item" ,11,1,5,1);

   JButton grabButton = addButton ("Grab 1st item", 12, 5,1,1);
   JButton grabButton2 = addButton ("Grab 2nd item", 13, 5,1,1);
   JButton dropButton = addButton ("Drop 1st item", 14, 5,1,1);
   JButton dropButton2 = addButton("Drop 2nd item", 15, 5,1,1);
   
   JButton northButton = addButton ("North", 12,2,1,1);
   JButton southButton = addButton ("South", 14,2,1,1);
   JButton eastButton = addButton ("East",   13,3,1,1);
   JButton westButton = addButton ("West",   13,1,1,1);
   JButton upButton = addButton ("Up", 12,3,1,1);
   JButton downButton = addButton ("Down", 14,3,1,1);

   AdventureGameModelFacade model;
   
   // Constructor-----------------------------------------------

   public AdventureGameView(){
	      setTitle ("Adventure Game");
	      try {
			model = new AdventureGameModelFacade();
		} catch (IOException e) {
			System.out.println("Error in AdventureGameModelFacade() call from AdventureGameView.java");
		}
      viewArea.setEditable (false);
      carryingArea.setEditable (false);
      displayCurrentInfo();
   } 
   
   
   // buttonClicked method--------------------------------------

   public void buttonClicked (JButton buttonObj){
      if (buttonObj == upButton){
    	  model.goUp();
      }

      else if (buttonObj == downButton){
    	  model.goDown();
      }
	 
      else if (buttonObj == northButton){
    	  model.goNorth();
      }

      else if (buttonObj == southButton){
    	  model.goSouth();
      }

      else if (buttonObj == eastButton){
    	  model.goEast();
      }

      else if (buttonObj == westButton){
    	  model.goWest();
      }

      else if (buttonObj == grabButton || buttonObj == grabButton2){
    	  try {
			if (buttonObj == grabButton) grab(1);
			if (buttonObj == grabButton2 && model.thePlayer.getLoc().getRoomContents().length == 2) grab(2);
			carryingArea.setText(model.getItems());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      else if (buttonObj == dropButton || buttonObj == dropButton2){
    	  if (buttonObj == dropButton) drop(1);
    	  System.out.println(model.thePlayer.numItemsCarried());
    	  if (buttonObj == dropButton2) drop(2);
      }

      displayCurrentInfo();
  }
       
   // Private methods-------------------------------------------

   private void displayCurrentInfo(){
	   viewArea.setText(model.getView());
	   carryingArea.setText(model.getItems());
   }

    // Left as an exercise. 
   public void grab(int itemNum) throws IOException {
      //  Set up a dialog to talk to the model and
      //  determine what items to pick up.
	   
	   model.grab(itemNum);
   }

    // Left as an exercise. 
    public void drop(int itemNum) {
	     //  Set up a dialog to talk to the model and 
             //  determine what items to pick up.
    	model.drop(itemNum);
   }

   public static void main (String[] args){
	   JFrame view = new AdventureGameView();
	   view.setSize (800, 600); /* was 400, 250  */             
	   view.setVisible(true);    
   }                    
}
