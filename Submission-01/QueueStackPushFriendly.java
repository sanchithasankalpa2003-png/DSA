
import java.util.*;

public class QueueStackPushFriendly {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int value) {
        q1.add(value);
        System.out.println(value + " pushed");
    }

    void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        System.out.println("Popped: " + q1.remove());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public static void main(String[] args) {

        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();
        stack.pop();
    }
}
