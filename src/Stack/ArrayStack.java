package Stack;

import Array.Array;

public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<T>(capacity);
    }

    public ArrayStack() {
        array = new Array<T>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
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
        stringBuffer.append("Stack: [ ");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuffer.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ] top");
        return stringBuffer.toString();
    }
}
