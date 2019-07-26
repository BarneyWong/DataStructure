package Queue;

public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(T t) {
        if ((tail + 1) % data.length == front) {
            reSize(getCapacity() * 2);
        }
        data[tail] = t;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue");
        }
        T ret = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            reSize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void reSize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        //易错
        front=0;
        tail=size;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Queue:size = %" + (getCapacity() + "").length() + "d, capacity = %" + (getCapacity()+ "").length() + "d\n", size, getCapacity()));
        res.append("Queue front [ ");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(String.format("%" + (size + "").length() + "d", data[i]));
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append(" ] tail");
        return res.toString();
    }
}
