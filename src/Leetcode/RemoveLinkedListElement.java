package Leetcode;

public class RemoveLinkedListElement {

    private static class ListNode<T> {
        private T val;
        private ListNode next;

        public ListNode(T val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
            this(null, null);
        }

        public ListNode(T t) {
            this(t, null);
        }
        public ListNode(T[] arr){
            if(arr==null&&arr.length==0){
                throw new IllegalArgumentException("Array can not be empty");
            }
            this.val=arr[0];
            ListNode cur = this;
            for(int i=1;i<arr.length;i++){
                cur.next=new ListNode(arr[i]);
                cur =cur.next;
            }
        }
        @Override
        public String toString() {
           StringBuffer stringBuffer = new StringBuffer();
           ListNode cur =this;
           while (cur!=null){
               stringBuffer.append(cur.val+"--> ");
               cur=cur.next;
           }
           stringBuffer.append("null");
           return stringBuffer.toString();
        }
    }

    public static<T> ListNode<T> removeElements(ListNode<T> head, T val) {
        ListNode<T> dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode<T> prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val.equals(val)) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> head= new ListNode<>(new Integer[]{1,2,3,5,6,8,6,4,9,7});
        removeElements(head,6);
        System.out.println(head);
    }
}
