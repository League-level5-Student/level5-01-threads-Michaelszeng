package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> c;
	public Worker(ConcurrentLinkedQueue<Task> c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (c.isEmpty() != true) {
			Task t = c.remove();
			t.perform();
		}
	}


}
