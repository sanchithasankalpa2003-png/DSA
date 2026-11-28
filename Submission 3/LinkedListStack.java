public class LinkedListStack {
    
    static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;
    int count = 0;

    void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        count++;
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }

        top = top.next;
        count--;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }

        return top.data;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }

        Node temp = top;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return count;
    }

    public static void main(String[] args) {
        
        LinkedListStack st = new LinkedListStack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("stack elements:");
        st.display();

        System.out.println("top element: " + st.peek());

        st.pop();

        System.out.println("after pop:");
        st.display();

        System.out.println("stack size: " + st.size());

        System.out.println("is empty: " + st.isEmpty());
    }
}
