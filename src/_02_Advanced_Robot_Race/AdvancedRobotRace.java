package _02_Advanced_Robot_Race;

import java.util.ArrayList;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	static int x = 16;
	static Robot[] robs = new Robot[x];
	static boolean won = false;
	static ArrayList<Thread> threads = new ArrayList<Thread>();
	public static void main(String[] args) {
		for (int i = 0; i < robs.length; i++) {
			robs[i] = new Robot();
			robs[i].setY(550);
			robs[i].setX((525 / (x + 1)) + (1050 / (x + 1)) * i);
			robs[i].setSpeed(10);
			Robot r = robs[i];
			threads.add(new Thread(()->startRacing(r)));
		}
		for (int i=0; i<threads.size(); i++) {
			threads.get(i).start();
		}
	}
	public static void startRacing(Robot rob) {
		while (!interrupted()) {
			Random ran = new Random();
			int ranDist = ran.nextInt(50);
			rob.move(ranDist);
			if (rob.getY() < 75) {
				rob.setSpeed(50);
				rob.turn(360);
				for (int i=0; i<threads.size(); i++) {
					threads.get(i).interrupt();
				}
			}
		}
	}
}
