
public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    // Insert at beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete a node
    public void delete(int data) {

        Node current = head;

        while (current != null &&
               current.data != data) {

            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    // Display forward
    public void displayForward() {

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {

            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    // Display backward
    public void displayBackward() {

        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {

            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.displayForward();
        list.displayBackward();

        list.insertAtBeginning(5);

        list.displayForward();

        list.delete(20);

        list.displayForward();
        list.displayBackward();
    }
}
