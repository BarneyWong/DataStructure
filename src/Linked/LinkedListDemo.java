package Linked;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int i=0;
        linkedList.add(i++);
        System.out.println(linkedList);
//        linkedList.addFirst(i++);
//        System.out.println(linkedList);
        linkedList.addLast(i++);
        System.out.println(linkedList);
        linkedList.add(i,i++);
        System.out.println(linkedList);
        linkedList.add(1);
        System.out.println(linkedList);
        linkedList.removeElement(1);
        System.out.println(linkedList);
    }
}
