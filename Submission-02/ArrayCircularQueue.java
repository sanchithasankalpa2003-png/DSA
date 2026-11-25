
public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {

        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        System.out.println(value + " inserted");
    }

    // Dequeue operation
    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int removed = queue[front];

        front = (front + 1) % capacity;
        size--;

        return removed;
    }

    // Peek operation
    public int peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Display queue
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue queue =
                new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Removed: " + queue.dequeue());

        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

        System.out.println("Front: " + queue.peek());
    }
}
