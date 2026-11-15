
import java.util.*;

public class QueueStackPopFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int value) {

        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println(value + " pushed");
    }

    void pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Popped: " + q1.remove());
    }

    public static void main(String[] args) {

        QueueStackPopFriendly stack = new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();
        stack.pop();
    }
}
