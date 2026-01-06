class Node1 {
    int value;
    Node1 next;

    Node1(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Stack {
    private Node1 top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int x) {
        Node1 newNode = new Node1(x);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        int returnVal = top.value;
        top = top.next;   // old node becomes unreachable
        return returnVal;
    }
}

class Main2 {
    public static void main(String[] args) {
        Stack s = new Stack();

        System.out.println(s.isEmpty()); // true

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop()); // 30
        System.out.println(s.pop()); // 20

        System.out.println(s.isEmpty()); // false

        s.pop(); // removes 10
        System.out.println(s.isEmpty()); // true
    }
}