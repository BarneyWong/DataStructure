package Stack;

import Linked.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list;
    public LinkedListStack(){
        list = new LinkedList<>();
    }
    @Override
    public void push(T t) {
        list.addFirst(t);
    }

    @Override
    public T pop() {
        return  list.removeFirst();
    }

    @Override
    public T peek() {
       return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
       return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Stack : top ");
        stringBuffer.append(list);
        return stringBuffer.toString();
    }
}
