

class Runner1 {
	public void execute() {
		for(int i=0; i < 10; ++i)
			System.out.println("Runner 1:"+i);
	}
}

class Runner2 {
	public void execute() {
		for(int i=0; i < 10; ++i)
			System.out.println("Runner 2:"+i);
	}
}

public class Runner {
	
	public static void main(String[] args) {

		// sequential processing
		Runner1 runner1 = new Runner1();
		Runner2 runner2 = new Runner2();

		runner1.execute();
		runner2.execute();
	}


}