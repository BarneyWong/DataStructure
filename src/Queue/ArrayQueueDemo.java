package Queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        for(int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if(i%3==0){
                System.out.println(arrayQueue.dequeue());
                System.out.println(arrayQueue);
            }
        }
    }
}
