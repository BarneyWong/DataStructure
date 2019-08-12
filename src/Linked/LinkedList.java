package Linked;


public class LinkedList<T> {
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

        @Override
        public String toString() {
            return t.toString();
        }
    }

    private Node dummyHead;
    //    private Node head;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;

    }

    public LinkedList(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        dummyHead = new Node();
        Node cur = dummyHead;
        for (int i = 0; i < array.length; i++) {
            cur.next = new Node(array[i]);
            cur = cur.next;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T t) {
        add(0, t);
    }

    //关键找到前一个节点。
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed ,Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(t);
        //顺序很重要。
        node.next = prev.next;
        prev.next = node;
//            prev.next = new Node(t,prev.next);
        size++;
    }

    //递归添加元素
    public void addLastWithRecursion(T t) {
        addLastWithRecursion(dummyHead.next, t);
    }

    private Node addLastWithRecursion(Node node, T t) {
        if (node == null) {
            size++;
            node = new Node(t);
            return node;
        } else {
            node.next = addLastWithRecursion(node.next, t);
            return node;
        }
    }

    public void addLast(T t) {
        add(size, t);
    }

    public void add(T t) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(t);
        size++;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed ,Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed ,Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.t = t;
    }

    public boolean contains(T t) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.t.equals(t)) {
                return true;
            }
            cur=cur.next;
        }

        return false;
    }

    public boolean containsWithRecursion(T t) {
        return containsWithRecursion(dummyHead.next, t);
    }

    private boolean containsWithRecursion(Node node, T t) {
        if (node == null) {
            return false;
        }
        if (t.equals(node.t)) {
            return true;
        } else {
            return containsWithRecursion(node.next, t);
        }
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed ,Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.t;
    }

    public void removeElement(T t) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed ,LinkedList is empty");
        }
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.t.equals(t)) {
                Node cur = prev.next;
                prev.next = cur.next;
                size--;
                cur.next = null;
                break;
            } else {
                prev = prev.next;
            }

        }
    }

    public void removeAllElement(T t) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Remove failed ,LinkedList is empty");
        }
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.t.equals(t)) {
                Node cur = prev.next;
                prev.next = cur.next;
                size--;
                cur.next = null;
            } else {
                prev = prev.next;
            }

        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuffer.append(cur + "--> ");
            cur = cur.next;
        }
//        for(Node cur =dummyHead.next;cur!=null;cur=cur.next){
//            stringBuffer.append(cur.t+"--> ");
//        }
        stringBuffer.append("NULL");
        return stringBuffer.toString();
    }
}
