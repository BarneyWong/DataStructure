package Array;

import Array.Array;

public class ArrayDemo {
    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        for(int i=0;i<10;i++){
            array.addLast(i);
        }
        System.out.println(array.toString());
        array.remove(2);
        System.out.println(array);
        array.add(9,9);
        array.addLast(10);
        System.out.println(array);
        System.out.println(array.findAll(9));
        array.removeAllElement(9);
        System.out.println(array);
        System.out.println(new Array<Integer>( new Integer[]{1,1,1,1,1,1,1}));
    }
}
