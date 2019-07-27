package Queue;


public class LinkedListQueue<T> implements Queue<T> {
    private class Node {
        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public void enqueue(T t) {
        if (tail == null) {
            tail = new Node(t);
            head=tail;
        } else {
            tail.next = new Node(t);
            tail=tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (head == null) {
            throw new IllegalArgumentException("Can't dequeue  from an  empty queue.");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.t;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.t;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Queue: head  ");
        for (Node node = head; node != null; node = node.next) {
            stringBuffer.append(node.t + "--> ");
        }
        stringBuffer.append("Null tail ");
        return stringBuffer.toString();
    }
}
