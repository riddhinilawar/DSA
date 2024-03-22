package design;

public class Solution2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadExample thread1 = new ThreadExample();
		thread1.start();
		Thread.sleep(1000);
		thread1.interrupt();
		
	}
}
class ThreadExample extends Thread{
	int count=0;
	
	public void run() {
		System.out.println("Thread started");
		try{
			while(count<5) {
				Thread.sleep(500);
				System.out.println("In thread, ount is::"+count);
				count++;
			}
		}
		catch(InterruptedException e){
			System.out.println("Thread Interrupted");
		}
	}
}
