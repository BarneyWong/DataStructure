package Stack;

import org.omg.PortableInterceptor.INACTIVE;

public class ArrayStackDemo {
    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());
        System.out.printf(arrayStack.toString());
    }

}
