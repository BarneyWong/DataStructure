package Array;


//数组可以快速查询
public class Array<T> {
    private T[] data;
    private int size;

    //无参数构造函数
    public Array() {
        this(10);
    }

    //有参构造函数
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    //参数是数组
    public Array(T[] ts) {
        data = ts;
        size = ts.length;
    }

    //获取元素个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //添加第一个元素
    public void addFirst(T t) {
        add(0, t);
    }

    //添加单个元素
    public void addLast(T t) {
        add(size, t);
    }

    //添加数组
    public void add(T[] ts) {
        for (int i = 0; i < ts.length; i++) {
            addLast(ts[i]);
        }
    }

    //在在指定位置插入一个元素
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed .Required index >=0 and index <=size");
        }
        //是否需要动态扩容
        if (size == data.length) {
            reSize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = t;
        size++;
    }
    public T getLast(){
        return get(size-1);
    }
    public T getFirst(){
        return get(0);
    }
    //根据索引获取数据
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed .Index is illegal.");
        }
        return data[index];
    }

    //根据所以修改
    public void set(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed ,Index is illegal");
        }
        data[index] = t;
    }

    //判断数组中是否包含某个元素。
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    //查询某个元素，返回索引值。
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //获取在数组中某个的元素的所有索引
    public Array findAll(T t) {
        Array indexes = new Array();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                indexes.addLast(i);
            }
        }
        return indexes;
    }

    //移除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    //移除最后一个元素
    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T t) {
        int index = find(t);
        if (index != -1) {
            remove(index);
        }
    }

//    public boolean removeElement(T t) {
//        int index = find(t);
//        int beforeSize = getSize();
//        if (index != -1) {
//
//            remove(index);
//        }
//        return (beforeSize - size) == 1 ? true : false;
//    }
    //移除数组中所有相同的元素
    public void removeAllElement(T t) {
        while (contains(t)) {
            removeElement(t);
        }
    }

//    public boolean removeAllElement(T t) {
//        while (contains(t)) {
//            removeElement(t);
//        }
//        return contains(t);
//    }

    //删除并返回已经删除的元素。
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed ,Index is illegal.");
        }
        //是否需要动态缩容
        if (size == data.length / 4 && data.length / 4 != 0) {
            reSize(data.length / 2);
        }
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return ret;
    }

    //数组容量变化
    private void reSize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array:size = %"+(data.length+"").length()+"d, capacity = %"+(data.length+"").length()+"d\n", size, data.length));
        res.append("Array [ ");
        for (int i = 0; i < size; i++) {
            res.append(String.format("%" + (size + "").length() + "d", data[i]));
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(" ]");
        return res.toString();
    }
}
