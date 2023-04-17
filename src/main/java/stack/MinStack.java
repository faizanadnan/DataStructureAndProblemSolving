package stack;

import java.util.Stack;

public class MinStack {
    static Stack<Integer> original = new Stack<>();
    static Stack<Integer> temp = new Stack<>();
    private static void push(int i) {
        original.push(i);

        if (temp.isEmpty() || temp.peek() >= i) {
            temp.push(i);
        }
    }

    private static void pop() {
        Integer pop = original.pop();

        if(temp.peek() == pop) {
            temp.pop();
        }
    }

    private static int minStack() {
        System.out.println(temp.peek());
        return temp.peek();

    }


    public static void main(String[] args) {

        push(3);

        push(2);
        push(1);
        push(4);
        push(3);

        pop();

        minStack();
        pop();
        minStack();

        pop();
        minStack();

        pop();
        minStack();
    }



}
