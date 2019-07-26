package Queue;

import Array.Array;

public class ArrayQueue<T>  implements  Queue<T>{
    private Array<T> array;
    public ArrayQueue(){
        array = new  Array<T>();
    }
    public ArrayQueue(int capacity){
       array =  new Array<T>(capacity);
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }
    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("Queue: front [");
      for(int i=0;i<array.getSize();i++){
          stringBuffer.append(array.get(i));
          if(i!=array.getSize()-1){
              stringBuffer.append(", ");
          }
      }
      stringBuffer.append(" ] tail");
      return stringBuffer.toString();
    }
}
