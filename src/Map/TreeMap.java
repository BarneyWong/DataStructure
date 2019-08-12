package Map;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node root;
    private int size;

    public TreeMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(root, k);
        if (node != null) {
            root = remove(root, k);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node successor =minimum(node.right);
                successor.right=removeMin(node.right);
                successor.left= node.left;
                node.left=node.right=null;
                return successor;
            }
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            throw new IllegalArgumentException(k + " does`nt exist in this.map");
        }
        node.value = v;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }
        return null;
    }
}
