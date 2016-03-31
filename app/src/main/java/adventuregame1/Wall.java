package adventuregame1;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
     
     Filename: Wall.java
     
     class Wall implements CaveSite
     
     Updated February 4 2016
     - added project comments				    
**/

/**
 * @authors
 * Zach Fuller
 * Josh Foley
 * Jason Ritzman
**/

// class Wall

public class Wall implements CaveSite {

    String caveMessage = "Ouch! That hurts.";

    public void enter(Player p) {

        System.out.println("Ouch! That hurts.");
 }

}

