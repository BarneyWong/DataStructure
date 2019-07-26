package Stack;

import Linked.LinkedList;
import Queue.Queue;

import java.util.Random;

public class Difference {
    private static double testStack(Stack stack,int couont){
        long start = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<couont;i++){
//            System.out.println(i);
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<couont;i++){
//            System.out.println(i);
            stack.pop();
        }
        long end = System.nanoTime();
        return (end-start)/1000000000.0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
        System.out.println("Array's time: "+testStack(arrayStack,100000));
        System.out.println("Loop's time: "+testStack(linkedListStack,100000));
    }
}
