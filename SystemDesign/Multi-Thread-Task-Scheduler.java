I have seen a lot of questions related to design a thread safe task scheduler being asked with basically two operations
schdeule task -> Non Blocking Operation (Could be done via ConcurrentLinkedQueue but not allowed to be used in Interview)
waitUntilComplete -> Wait till all tasks are done.

Here's my implementation for the same, need the community's review and feedback for correctness.

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TaskScheduler<E> {
    private NonBlockingQueue<E> tasks;
    public TaskScheduler() {
        tasks = new NonBlockingQueue<>();
    }

    public void schedule(E task){
        tasks.add(task);
    }

    public synchronized void waitUntilComplete() throws InterruptedException{
        while(tasks.poll()){
            wait();
        }
        System.out.println("Done");
    }
}



class NonBlockingQueue<T> {


    private final AtomicReference<Node<T>> head, tail;
    private final AtomicInteger size;

    public NonBlockingQueue() {
        head = new AtomicReference<>(null);
        tail = new AtomicReference<>(null);
        size = new AtomicInteger();
        size.set(0);
    }

    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        Node<T> node = new Node<>(element);
        Node<T> currentTail;
        do {
            currentTail = tail.get();
            node.setPrevious(currentTail);
        } while(!tail.compareAndSet(currentTail, node));

        if(node.getPrevious() != null) {
            node.getPrevious().setNext(node);
        }

        head.compareAndSet(null, node);
        size.incrementAndGet();
    }

    public T get() {
        if(head.get() == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentHead;
        Node<T> nextNode;
        do {
            currentHead = head.get();
            nextNode = currentHead.getNext();
        } while(!head.compareAndSet(currentHead, nextNode));

        size.decrementAndGet();
        return currentHead.getValue();
    }

    public boolean poll() {
        Node<T> head, next;

        // move head node to the next node using atomic semantics
        // as long as next node is not null
        do {
            head = this.head.get();
            next = head.getNext();
            if (next == null) {
                // empty list
                return false;
            }
            // try until the whole loop executes pseudo-atomically
            // (i.e. unaffected by modifications done by other threads)
        } while (!this.head.compareAndSet(head, next));

        T value = next.getValue();

        // release the value pointed to by head, keeping the head node dummy
        next.setValue(null);
        size.decrementAndGet();
        return true;
    }
}

class Node<T> {
    private volatile T value;
    private volatile Node<T> next;
    private volatile Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setValue(T value) {
        this.value = value;
    }
}


