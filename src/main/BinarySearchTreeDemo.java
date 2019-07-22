package main;

import BinarySearchTree.BinarySearchTree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        int[] nums ={4,2,5,6,7,1};
        for(int i:nums){
            binarySearchTree.add(i);
        }
        binarySearchTree.preOrder();
    }
}
