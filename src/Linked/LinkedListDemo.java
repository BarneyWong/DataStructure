package Linked;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int i=0;
        linkedList.add(i++);
        System.out.println(linkedList);
//        linkedList.addFirst(i++);
//        System.out.println(linkedList);
        linkedList.addLastWithRecursion(i++);
        System.out.println(linkedList);
        linkedList.add(i,i++);
        System.out.println(linkedList);
        linkedList.add(1);
        System.out.println(linkedList);
        linkedList.removeElement(1);
        System.out.println(linkedList);
        linkedList.addFirst(5);
        System.out.println(linkedList);
        System.out.println(linkedList.containsWithRecursion(4));
        System.out.println(new LinkedList<Integer>(new Integer[]{1,2,3,5,6,8,6,4,9,7}));
    }
}
