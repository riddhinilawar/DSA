package design;

public class SingleTonEx {
	public static void main(String[] args) {

		Thread thread1 = new Thread(() -> {abc obj = abc.getObj();}) ;
		Thread thread2 = new Thread(() -> {abc obj = abc.getObj();}) ;
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//abc obj = abc.getObj();
		//obj.display();
	}
}
class abc{
	private abc() {

	}
	public static abc obj;
	public static abc getObj() {
		if(obj==null) {
			getObj1();
		}
		return obj;
	}
	synchronized public static void getObj1() {
		if(obj==null) {
			obj=new abc();
			System.out.println("Creating object");
		}
		
	}
	public void display() {
		System.out.println("Hello Vinit");
	}
}
