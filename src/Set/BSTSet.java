package Set;


import BinarySearchTree.BinarySearchTree;

public class BSTSet<T extends Comparable<T>> implements Set<T> {
    private BinarySearchTree<T> bst;

    public BSTSet() {
       bst = new BinarySearchTree<T>();
    }

    @Override
    public void add(T t) {
        bst.add(t);
    }

    @Override
    public void remove(T t) {
        bst.remove(t);
    }

    @Override
    public boolean contains(T t) {
        return bst.contains(t);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

}
