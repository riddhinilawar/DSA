package design;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedAtm {
	private Lock lock;
	private int balance =100;
	
	public LockedAtm() {
		lock = new ReentrantLock();
	}
	
	public int withdraw(int value) {
		lock.lock();
		int temp=balance;
		try {
			Thread.sleep(100);
			temp=temp-value;
			balance = temp;
		}
		catch(InterruptedException e){
			
		}
		lock.unlock();
		return temp;
	}
	
	public int deposit(int value) {
		lock.lock();
		int temp=balance;
		try {
			Thread.sleep(temp);;
			temp=temp+value;
			Thread.sleep(300);
			balance = temp;
		}
		catch(InterruptedException e) {
			
		}
		lock.unlock();
		return temp;
	}
}
