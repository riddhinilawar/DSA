package design;

class RunnableThreadExample implements Runnable{
	
	public int count=0;
	
	public void run() {
		System.out.println("Runnable Thraed Start");
		
		try {
			while(count<=5){
				System.out.println(count);
				Thread.sleep(500);
				count++;
			}
		}
		catch(InterruptedException e) {
			System.out.println("RunnableThread Interrupted");
		}
		
		System.out.println("Runnable Thread executed");
	}
}
public class Solution{
	public static void main(String[] args) {
		RunnableThreadExample runnableObj = new RunnableThreadExample();
		Thread thread1 = new Thread(runnableObj);
		thread1.start();
		System.out.println("Hello");
		System.out.println(Thread.currentThread().getName());
	}
}
