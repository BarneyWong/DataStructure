package Stack;

//栈的应用：undo操作、程序调用的系统栈、括号匹配器
public interface Stack<T> {
    void push(T e);     //复杂度 O(1) 均摊

    T pop();            //复杂度 O(1) 均摊

    T peek();           //复杂度 O(1)

    int getSize();      //复杂度 O(1)

    boolean isEmpty();  //复杂度 O(1)
}
