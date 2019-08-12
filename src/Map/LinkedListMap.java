package Map;

public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        private K k;
        private V v;
        private Node next;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K k) {
            this(k, null, null);
        }

        @Override
        public String toString() {
            return k.toString() + ":" + v.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K k) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.k.equals(k)) {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);

        if (node == null) {
            Node newNode = new Node(k, v, null);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            size++;
//            dummyHead.next = new Node(k,v,dummyHead.next);
        } else {
            node.v = v;
        }
    }

    @Override
    public V remove(K k) {
        Node prev = dummyHead;
        //获取要删除节点的前一个节点Prev
        while (prev.next != null) {
            if (prev.next.k.equals(k)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.v;
        }
        return null;

    }

    @Override
    public boolean contains(K k) {
        return  getNode(k)!=null;
    }

    @Override
    public V get(K k) {

        return getNode(k).v;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException(k + " doesn`t exist in this.map");
        } else {
            node.v = v;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
