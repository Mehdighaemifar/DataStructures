public class Queue {
    private int[] arr;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        size = 0;
        rear = -1;
    }

    // Enqueue: add element to the rear
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    // Dequeue: remove element from the front
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }
}

class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        // Test enqueue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        // Test dequeue
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        // More enqueue
        q.enqueue(50);
        q.enqueue(60);

        // Peek front element
        System.out.println("Front element: " + q.peek()); // 30

        // Dequeue remaining elements
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
