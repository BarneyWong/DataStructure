package Queue;

public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front ,tail;
    private int size;

    public LoopQueue(int capacity){
        data=(T[])new Object[capacity+1];
        size=0;
        front=0;
        tail=0;
    }

    public LoopQueue(){
       this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public void enqueue(T t) {
        if((tail+1)%data.length==front){
            reSize(getCapacity()*2);
        }
        data[tail]=t;
        tail = (tail+1)%data.length;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T getFont() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    private void reSize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity+1];
        for(int i=0;i<size;i++){
            newData[i]=data[(front+i)%data.length];
        }
        data=newData;
    }
}
