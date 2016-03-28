package AdventureGame;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main	
     
     class Item: contains getters and setters for
	 an item's description as it is a private variable
	 
	 Updated February 4 2016
	 - added project & functionality comments
**/

/** 
 * @authors 
 * Zach Fuller
 * Josh Foley
 * Jason Ritzman
**/

// class Item

public class Item {

  private String description;

  //setter needed as Items are private
  public void setDesc(String d){
      description = d;
  }
  //getter needed as Items are private
  public String getDesc(){
	     return description;
  }
  public String toString(){
	  return description;
  }

}

