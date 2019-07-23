package Queue;

public interface Queue<T> {
    void enqueue(T t);

    T dequeue();

    T getFont();

    int getSize();

    boolean isEmpty();
}
