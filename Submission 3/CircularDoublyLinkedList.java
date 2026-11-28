public class CircularDoublyLinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;

    void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
            return;
        }

        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        head.prev = newNode;

        head = newNode;
    }

    void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            insertFirst(data);
            return;
        }

        Node tail = head.prev;

        newNode.prev = tail;
        newNode.next = head;

        tail.next = newNode;
        head.prev = newNode;
    }

    void insertAtPosition(int data, int pos) {
        if (pos < 0) {
            System.out.println("invalid position");
            return;
        }

        if (pos == 0) {
            insertFirst(data);
            return;
        }

        if (head == null) {
            System.out.println("invalid position");
            return;
        }

        Node temp = head;
        int index = 0;

        while (index < pos - 1 && temp.next != head) {
            temp = temp.next;
            index++;
        }

        if (index != pos - 1) {
            System.out.println("invalid position");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    void insertAfter(int key, int data) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == key) {
                Node newNode = new Node(data);

                newNode.next = temp.next;
                newNode.prev = temp;

                temp.next.prev = newNode;
                temp.next = newNode;

                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("key not found");
    }

    void insertBefore(int key, int data) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == key) {

                if (temp == head) {
                    insertFirst(data);
                    return;
                }

                Node newNode = new Node(data);

                newNode.prev = temp.prev;
                newNode.next = temp;

                temp.prev.next = newNode;
                temp.prev = newNode;

                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("key not found");
    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node tail = head.prev;

        head = head.next;

        head.prev = tail;
        tail.next = head;
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node tail = head.prev;
        Node newTail = tail.prev;

        newTail.next = head;
        head.prev = newTail;
    }

    void deleteAtPosition(int pos) {
        if (pos < 0 || head == null) {
            System.out.println("invalid position");
            return;
        }

        if (pos == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;
        int index = 0;

        while (index < pos && temp.next != head) {
            temp = temp.next;
            index++;
        }

        if (index != pos) {
            System.out.println("invalid position");
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void deleteByValue(int key) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == key) {

                if (temp == head) {
                    deleteFirst();
                    return;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                return;
            }

            temp = temp.next;

        } while (temp != head);

        System.out.println("key not found");
    }

    void display() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertAtPosition(30, 2);

        System.out.println("original list:");
        list.display();

        list.insertAfter(20, 25);
        System.out.println("after insertAfter:");
        list.display();

        list.insertBefore(40, 35);
        System.out.println("after insertBefore:");
        list.display();

        list.deleteFirst();
        System.out.println("after deleteFirst:");
        list.display();

        list.deleteLast();
        System.out.println("after deleteLast:");
        list.display();

        list.deleteAtPosition(1);
        System.out.println("after deleteAtPosition:");
        list.display();

        list.deleteByValue(25);
        System.out.println("after deleteByValue:");
        list.display();
    }
}
