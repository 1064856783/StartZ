package test;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("run():"+i+"@"+this.getPriority() );
		}
	}
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		for (int i = 0; i < 50; i++) {
			System.out.println("main():"+i+"@"+myThread.getPriority() );
			
		}
	}

}
