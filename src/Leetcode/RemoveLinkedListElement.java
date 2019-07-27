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

        public ListNode(T[] arr) {
            if (arr == null && arr.length == 0) {
                throw new IllegalArgumentException("Array can not be empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            ListNode cur = this;
            while (cur != null) {
                stringBuffer.append(cur.val + "--> ");
                cur = cur.next;
            }
            stringBuffer.append("null");
            return stringBuffer.toString();
        }
    }

    public static <T> ListNode<T> removeElements(ListNode<T> head, T val) {
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

    public static <T> ListNode<T> removeElementWithRecursion(ListNode<T> head, T val, int depth) {
        System.out.print(generateDepthString(depth));
        System.out.println(head);
        if (head == null) {
            return null;
        }

        ListNode<T> res = removeElementWithRecursion(head.next, val, depth + 1);
        System.out.println(generateDepthString(depth+1)+res);
//        System.out.println("head:" + head.val + " return: " + res);
        ListNode<T> ret;
        if (head.val == val) {
            ret= res;
        } else {
            head.next = res;
           ret = head;
        }
        return ret;
//        head.next = removeElementWithRecursion(head.next, val);
//        return head.val == val ? head.next : head;
    }

    private static String generateDepthString(int depth) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            stringBuffer.append("     ");
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(new Integer[]{1, 2, 3, 4});
        removeElementWithRecursion(head, 6, 0);
        System.out.println(head);
    }
}
