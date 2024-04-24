Here's a basic Java code example illustrating this scenario:

java
Copy code
public class DeadlockExample {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Holding resource 1...");
                try {
                    Thread.sleep(100); // Simulating some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for resource 2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holding resource 1 and resource 2...");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Holding resource 2...");
                try {
                    Thread.sleep(100); // Simulating some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for resource 1...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Holding resource 2 and resource 1...");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
This code creates two threads (thread1 and thread2) where each thread locks one resource and then tries to lock the other. This setup can potentially lead to a deadlock if both threads start simultaneously, as they could each hold one resource and wait indefinitely for the other resource to be released.

Please note that running this code may not always result in a deadlock, as it depends on the timing and scheduling of threads by the JVM. However, analyzing the code can help understand the conditions that could lead to a deadlock.
