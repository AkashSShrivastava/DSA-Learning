package Queue;

import java.util.Scanner;

public class CircularQueue {

    private final int[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println( "Queue is full.");
        } else {
            size++;
            queue[rear%capacity] = item;
            rear = (rear+1)%capacity;
            System.out.println( "Item " + item + " enqueued at rear= " + rear + " and front= " + front + " and size= " + size + " and capacity= " + capacity + ".");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println( "Queue is empty.");
            return 0;
        } else {
            size--;
            int item = queue[front%capacity];
            queue[front%capacity] = Integer.MIN_VALUE;
            front = front+1%capacity;
            return item;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CircularQueue queue = new CircularQueue(5);
        while (true) {
            System.out.println("Choose Options: \n1. ENQUEUE \n2. DEQUEUE\n3. PRINT QUEUE");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the number of items to be enqueued: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        queue.enqueue(sc.nextInt());
                    }
                    break;
                case 2:
                    System.out.println("Dequeued Item: " + queue.dequeue());
                    break;
                case 3:
                    System.out.println("Queue: ");
                    for (int i = 0; i < queue.size; i++) {
                        System.out.print(queue.queue[(queue.front+i)%queue.capacity] + " ");
                    }
                    System.out.println("Size: " + queue.size);
                    System.out.println("Front: " + queue.front);
                    System.out.println("Rear: "+ queue.rear);
            }
        }
    }
}
