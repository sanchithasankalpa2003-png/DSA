
public class UnboundedArrayStack {

    int[] stack = new int[2];
    int top = -1;

    void push(int value) {

        if (top == stack.length - 1) {
            int[] newStack = new int[stack.length * 2];

            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
            System.out.println("Array size increased");
        }

        stack[++top] = value;
        System.out.println(value + " pushed");
    }

    void pop() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Popped: " + stack[top]);
        top--;

        if (stack.length > 2 && top + 1 <= stack.length / 4) {

            int[] newStack = new int[stack.length / 2];

            for (int i = 0; i <= top; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
            System.out.println("Array size decreased");
        }
    }

    public static void main(String[] args) {

        UnboundedArrayStack s = new UnboundedArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        s.pop();
        s.pop();
        s.pop();
    }
}
