package Stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
        for(int i=0;i<5;i++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
            if(i%3==2){
                linkedListStack.pop();
                System.out.println(linkedListStack);
            }
        }
    }
}
