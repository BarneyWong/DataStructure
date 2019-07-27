package Queue;

import java.util.Random;

public class Difference {
    private static double testQueue(Queue queue,int couont){
        long start = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<couont;i++){
//            System.out.println(i);
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<couont;i++){
//            System.out.println(i);
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end-start)/1000000000.0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
//        System.out.println("Array's time: "+testQueue(arrayQueue,100000));
        System.out.println("Loop's time: "+testQueue(loopQueue,10000000));
        System.out.println("LinkedList's time: "+testQueue(linkedListQueue,10000000));
    }
}
