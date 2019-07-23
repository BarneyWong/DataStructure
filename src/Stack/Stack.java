package Stack;

//栈的应用：undo操作、程序调用的系统栈
public interface Stack<T> {
    void push(T e);

    T pop();

    T peek();

    int getSize();

    boolean isEmpty();
}
