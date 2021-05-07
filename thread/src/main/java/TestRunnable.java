
public class TestRunnable {

	static class MyCallable implements Runnable {
		
		private String name;
		public MyCallable(String name) {
			this.name = name;
		}
		
		@Override
		//public void run() {
		public synchronized void run() {
			
			synchronized(this) {
				System.out.println(this.name + " got the lock.");
			}
			
			for(int i = 0; i < 10 ; i++) {
				System.out.println(this.name + " reports: i = " + i);
			}
		}
	}

	public static void main(String[] args) {
		MyCallable mycallableA = new MyCallable("Thread A");
		MyCallable mycallableB = new MyCallable("Thread B");
		MyCallable mycallableC = new MyCallable("Thread C");
		
        new Thread(mycallableA).start();
        new Thread(mycallableA).start();
        new Thread(mycallableC).start();
	}	
}