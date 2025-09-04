package Queue;

public class ReverseQueue {
    private int[] queue;
    int front;
    int rear;
    int size;
    final int capacity = 10;
    
    ReverseQueue() {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int item) {
        rear++;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        } else {
            size++;
            front++;
            return queue[front];
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        //Logic to reverse using enqueue and dequeue
        ReverseQueue queue = new ReverseQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
