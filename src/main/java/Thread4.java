

public class Thread4 {
	
	public static int counter1 = 0;
	public static int counter2 = 0;

	public static void increment1() {
		synchronized (Thread4.class) {
			counter1++;
		}
		
	}
	
	public static void increment2() {
		synchronized (Thread4.class) {
			counter2++;
		}
	}
	
	public static void process() {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<100; ++i)
					increment1();
			}
		});
		
        Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<100; ++i)
					increment2();
			}
		});
        
        t1.start();
        t2.start();
        
        try {
			t1.join();
		    t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
		System.out.println("The counter1 is: " + counter1);
		System.out.println("The counter2 is: " + counter2);
	}
	
	public static void main(String[] args) {
		process();
	}

}
