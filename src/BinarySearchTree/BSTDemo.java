package BinarySearchTree;


import java.util.ArrayList;
import java.util.Random;

public class BSTDemo {
    //    public static void main(String[] args) {
//        BinarySearchTree<Integer> searchTree= new BinarySearchTree<Integer>();
//        int[] nums = {5,3,6,8,4,2,7,9,10,};
//        for(int num:nums){
//            searchTree.add(num);
//        }
////        System.out.println(searchTree.contains(1));
////        searchTree.preOrder();
////        searchTree.midOrder();
//        searchTree.depthOrder();
//        searchTree.levelOrder();
////        System.out.println(searchTree);
//    }
    public static void main(String[] args) {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        Random random = new Random();
        int n =1000;
        for(int i =0;i<n;i++){
            binarySearchTree.add(random.nextInt(10000));
        }
        System.out.println(binarySearchTree.size());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!binarySearchTree.isEmpty()){
            arrayList.add(binarySearchTree.removeMin());
        }
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        for(int i=1;i<arrayList.size();i++){
            if(arrayList.get(i-1)>arrayList.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("RemoveMin test completed .");
    }
}
