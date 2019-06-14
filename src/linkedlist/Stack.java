package linkedlist;

/**
 * 自定义栈接口
 *
 * @param <E>
 */
public interface Stack<E> {

    // 获取栈中元素个数
    int getSize();

    // 判断栈是否为空
    boolean isEmpty();

    // 元素入栈
    void push(E e);

    // 元素出栈
    E pop();

    // 查看栈顶元素
    E peek();
}
