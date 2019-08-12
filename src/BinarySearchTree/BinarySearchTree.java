package BinarySearchTree;

import java.util.*;
import java.util.Set;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return false;
//        Node cur = node;
//        while (true) {
//            if (cur == null) {
//                return false;
//            }
//            if (e.compareTo(cur.e) == 0) {
//                return true;
//            }
//            if (e.compareTo(cur.e) < 0) {
//                cur = cur.left;
//            } else {
//                cur = cur.right;
//            }
//        }
    }


    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的前序非递归遍历 深度优先遍历
    public void depthOrder() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void levelOrder(){
        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    //释放内存。
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    public E minimum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    public E maximum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin(){
        E ret =minimum();

        root =removeMin(root);
        return ret;
    }
    private Node  removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right= null;
            size--;
            return  rightNode;
        }else{
            node.left = removeMin(node.left);
            return node;
        }

    }

    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            Node  leftNode = node.left;
            node.left=null;
            size--;
            return leftNode;
        }else{
            node.right = removeMax(node.right);
            return node;
        }
    }

    public void remove(E e){
//        if(size==0){
//            throw new IllegalArgumentException("Remove failed,BST is empty");
//        }
        root = remove(root ,e);
    }

    private Node  remove(Node node ,E e){
           if(node ==null){
               return null;
           }
           if(e.compareTo(e)<0){
               node.left = remove(node.left,e);
               return node;
           }else if(e.compareTo(e)>0){
               node.right = remove(node.right,e);
               return node;
           }else{
                if(node.left==null){
                    Node rightNode = node.right;
                    node.right=null;
                    size --;
                    return rightNode;
                }
                if(node.right==null){
                    Node leftNode = node.left;
                    node.left=null;
                    size--;
                    return leftNode;
                }
                //待删除节点左右节点不为空的情况
                //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                //用这个节点顶替待删除节点
                Node successor = minimum(node.right);
                successor.left = node.left;
                successor.right= removeMin(node.right);//有一次size--
                size++;
                node.left=null;
                node.right=null;
                size--;

                return  successor;

//               Node precursor = maximum(node.left);
//               precursor.left= removeMax(node.left);
//               precursor.right= node.right;
//               node.left= null;
//               node.right=null;
//               return precursor;
           }
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        generateBSTString(root, 0, stringBuffer);
        return stringBuffer.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuffer stringBuffer) {
        if (node == null) {
            stringBuffer.append(generateDepthString(depth) + "null \n");
        } else {
            stringBuffer.append(generateDepthString(depth) + node.e + "\n");
            generateBSTString(node.left, depth + 1, stringBuffer);
            generateBSTString(node.right, depth + 1, stringBuffer);
        }
    }

    private String generateDepthString(int depth) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            stringBuffer.append("--");
        }
        return stringBuffer.toString();
    }
}

