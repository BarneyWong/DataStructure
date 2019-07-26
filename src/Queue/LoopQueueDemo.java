package Queue;



public class LoopQueueDemo {
    public static void main(String[] args) {
        LoopQueue<Integer> integerLoopQueue = new LoopQueue<Integer>();
        for(int i =0;i<10;i++){
            integerLoopQueue.enqueue(i);
            System.out.println(integerLoopQueue);
            if(i%3==2){
                integerLoopQueue.dequeue();
                System.out.println(integerLoopQueue);
            }
        }
    }
}
