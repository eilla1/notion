// import java.util.Scanner;

// import javax.swing.JOptionPane;

import kareltherobot.*;

public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method
	Robot roomba; 


	// You will add very many variables!!

	
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();
		d.getInfo();
		d.scanRoom();
		d.cleanRoom();
		d.displayResults();
	}

	public void turnRight() {
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
	}

	private int scanRoom() {
		for (int i = 0; i<3; i++) {
		while (roomba.frontIsClear()) {
			roomba.move();
			collectBeeper();
		}
		turnRight();
		roomba.move();
		turnRight();
		while (roomba.frontIsClear()) {
			roomba.move();
			collectBeeper();
		}
		roomba.turnLeft();
		roomba.move();
		roomba.turnLeft();
	}

		return 0;
	}

	private int collectBeeper() {
		if (roomba.nextToABeeper()) {
			while (roomba.nextToABeeper()) {
				roomba.pickBeeper();
			}
		}
		return 0;
	}

	/**
	 * This method gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 
	 * 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */
	private void getInfo() {
		int yPosition = 11;
		int xPosition = 6;
		roomba = new Robot(yPosition, xPosition, Directions.East, 0);
		String wrldName = "basicRoom.wld";

		World.readWorld(wrldName);
		World.setVisible(true);
		World.setDelay(5);

	}

	/** This method will have all the logic that takes the Robot to every location 
	 * and cleans up all piles of beepers.  Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */
	private void cleanRoom() {
		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		roomba.move();

		// obviously, lots more here
	}

	/** This method displays the results of cleaning the room.  All of the info
	 * in the pdf that describes the problem need to be displayed.  You can present
	 * this info in the console (boring) or you can present using JOptionPane (cool!)
	 */
	private void displayResults() {
		
		System.out.println("The biggest pile was ");
		// JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
	}

}

// Information to return to the user
// • Area of room
// • Number of piles
// • Total number of beepers
// • Largest pile of beepers
// • Location (relative) of the largest pile
// • average pile size
// • percent dirty (piles/area)