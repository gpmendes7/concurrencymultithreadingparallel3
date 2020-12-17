package priorityblockingqueueexample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Person implements Comparable<Person> {
	
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Person otherPerson) {
		return Integer.compare(this.age, otherPerson.getAge());
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "-" + age;
	}
	
}

class FirstWorker implements Runnable {

	private BlockingQueue<Person> blockingQueue;

	public FirstWorker(BlockingQueue<Person> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put(new Person(12, "Adam"));
			blockingQueue.put(new Person(45, "Joe"));
			blockingQueue.put(new Person(78, "Daniel"));
			Thread.sleep(1000);
			blockingQueue.put(new Person(32, "Noel"));
			Thread.sleep(1000);
			blockingQueue.put(new Person(34, "Kevin"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class SecondWorker implements Runnable {

	private BlockingQueue<Person> blockingQueue;

	public SecondWorker(BlockingQueue<Person> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class PriorityBlockingQueueExample {

	public static void main(String[] args) {
		
		BlockingQueue<Person> queue = new PriorityBlockingQueue<>();
		
		new Thread(new FirstWorker(queue)).start();
		new Thread(new SecondWorker(queue)).start();;
	}

}
