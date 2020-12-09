

class Process {
	
	public void produce() throws InterruptedException {
		
		synchronized (this) {
			System.out.println("Running the produce method...");
			wait();
			System.out.println("Again in the producer method...");
		}
		
	}
	
    public void consume() throws InterruptedException {
		Thread.sleep(1000);
		
		synchronized (this) {
			System.out.println("Consumer method is executed...");
			notify();
			Thread.sleep(5000);
		}
	}
	
}

public class ProducerConsumer1 {
	
	public static void main(String[] args) {
		
		Process process = new Process();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
        Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        t1.start();
        t2.start();
	}

}
