package _03_Threaded_Reverse_Greeting;

import java.lang.reflect.Array;

public class ThreadedReverseGreeting {
  static //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	/* HINT: You will most likely need to do this with recursion */
	boolean[] orderFixer = new boolean[50];
	public static void main(String[] args) {
		
		for (int i=0; i<50; i++) {
			orderFixer[i] = false;
		}
		
		Thread t1 = new Thread(()->makeThread(1));
		t1.start();
	}
	
	public static void makeThread(int num) {
		if (num >= 50) {
			System.out.println("Hi from thread " + num);
			orderFixer[48] = true;
		}
		else {
			Thread t2 = new Thread(()->makeThread(num+1));
			t2.start();
			while (orderFixer[num-1] != true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Hi from thread " + num);
			if (num > 1) {
				orderFixer[num-2] = true;
			}
		} 
	}
}
