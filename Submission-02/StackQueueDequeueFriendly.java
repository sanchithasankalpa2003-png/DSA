
public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete a node
    public void delete(int data) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != data) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found");
        } else {
            current.next = current.next.next;
        }
    }

    // Search for a value
    public boolean search(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display list
    public void display() {

        Node current = head;

        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Linked List: ");

        while (current != null) {

            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.display();

        list.insertAtBeginning(5);

        list.display();

        list.delete(20);

        list.display();

        System.out.println("Search 30: " + list.search(30));
    }
}
