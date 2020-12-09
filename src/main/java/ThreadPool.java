
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable {
	private int id;
	
	public Work(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Task with id " + id + " is in work - thread id: " + Thread.currentThread().getId());
		long duration = (long) Math.random()*5;
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadPool {
	
	public static void main(String[] args) {	
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for(int i=0; i<100;i++)
			executor.execute(new Work(i+1));
	}

}
