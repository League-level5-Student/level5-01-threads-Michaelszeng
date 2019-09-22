package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> c;

	public ThreadPool(int i) {
		// TODO Auto-generated constructor stub
		threads = new Thread[i];
		c = new ConcurrentLinkedQueue<Task>();
		for (int i1=0; i1<threads.length; i1++) {
			threads[i1] = new Thread((new Worker(c)));
		}
	}

	public void addTask(Task t) {
		// TODO Auto-generated method stub
		c.add(t);
	}

	public void start() {
		// TODO Auto-generated method stub
		for (int i=0; i<threads.length; i++) {
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
