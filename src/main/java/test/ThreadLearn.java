package test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLearn implements Runnable{
	@Override
	public void run() {
		
	}
}

class TestThread extends Thread{
	@Override
	public void run() {
		
		super.run();
	}
	public static AtomicInteger race = new AtomicInteger(0);
	public static void increase() {
//		race++;
		race.getAndIncrement();
	}
	
}
