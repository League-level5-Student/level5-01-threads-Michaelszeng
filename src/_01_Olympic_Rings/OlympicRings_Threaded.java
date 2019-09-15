package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot r1 = new Robot();
		Robot r2 = new Robot();
		Robot r3 = new Robot();
		Robot r4 = new Robot();
		Robot r5 = new Robot();
		
		r1.moveTo(300,500);
		r2.moveTo(500, 700);
		r3.moveTo(700, 500);
		r4.moveTo(900, 700);
		r5.moveTo(1100, 500);
		
		r1.setPenColor(0, 0, 255);
		r2.setPenColor(255, 175, 0);
		r3.setPenColor(0, 0, 0);
		r4.setPenColor(Color.green);
		r5.setPenColor(Color.red);
		
		r1.penDown();
		r2.penDown();
		r3.penDown();
		r4.penDown();
		r5.penDown();
		
		Thread t1 = new Thread(()->makeCircle(r1));
		Thread t2 = new Thread(()->makeCircle(r2));
		Thread t3 = new Thread(()->makeCircle(r3));
		Thread t4 = new Thread(()->makeCircle(r4));
		Thread t5 = new Thread(()->makeCircle(r5));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	public static void makeCircle(Robot r) {
		for (int i=0; i<180; i++) {
			r.move(6);
			r.turn(2);
		}
	}
}

