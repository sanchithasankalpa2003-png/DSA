public class LinkedListFIFOQueue {
    
    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;
    int count = 0;

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty"); 
            return;
        }

        front = front.next;

        if (front == null) {
            rear = null;
        }
        count--;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }

        return front.data;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }

        Node temp = front;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    boolean isEmpty() {
        return front == null;
    }

    int size() {
        return count;
    }

    public static void main(String[] args) {
        
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("queue elements:");
        q.display();

        System.out.println("front element: " + q.peek());

        q.dequeue();

        System.out.println("after dequeue:");
        q.display();

        System.out.println("queue size: " + q.size());

        System.out.println("is empty: " + q.isEmpty());
    }
}
