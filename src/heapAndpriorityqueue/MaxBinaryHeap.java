package heapAndpriorityqueue;

/**
 * 自定义最大二叉堆类
 *
 * @param <E>
 */
public class MaxBinaryHeap<E extends Comparable<E>> {

    private Array<E> data; // 底层数据结构为数组

    public MaxBinaryHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxBinaryHeap() {
        data = new Array<>();
    }

    /**
     * 构造器:将一个任意类型的数据构造成最大二叉堆
     */
//    public MaxBinaryHeap(E[] arr){
//        data = new Array<>(arr);
//        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
//            siftDown(i);
//    }

    // 返回堆中的元素个数
    public int getSize() {
        return data.getSize();
    }

    // 返回一个布尔值，判断堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 通过给定索引，返回完全二叉树的数组中该索引表示的节点的父节点的索引，
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't hve parent.");
        }
        return (index - 1) / 2;
    }

    // 通过给定索引，返回完全二叉树的数据中该索引表示的节点的左子节点的索引
    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    // 通过给定索引，返回完全二叉树的数据中该索引表示的节点的右子节点的索引
    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    // 向堆中添加一个元素 Sift Up，元素上浮
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // 由索引元素进行元素上浮Sift Up
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k)); // 调用了数组类中的公用方法swap()，调用两个索引的对应元素
            k = parent(k); // 为下轮循环做准备
        }
    }

    // 看当前堆中最大元素
    public E findMax() {
        if (data.getSize() == 0) throw new IllegalArgumentException("Can't findMax when heap is empty.");
        return data.get(0);
    }


    // 从堆中取出最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1); // 直接首尾交换，然后删除末尾即可直接删除最大值且把最小值放到最前面
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // 由索引元素进行元素下沉Sift Down====>有点东西！！！
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {  // k这个节点的左子节点没有数组越界，即：左孩子也存在
            int j = leftChild(k);
            if ((j + 1) < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {  // k这个节点的右子节点没有数组越界，即：右孩子也存在
                j++;  // 精妙之处:上一步的判断到了右子节点存在，且左子节点小于右子节点。这一步，就直接定义了j到底是左子节点还是右子节点，牛逼，真的牛逼！
            }
            // 不管怎样，此时的data[j]里面存储的都是左右子节点中更大的那个值。
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    // 取出最大元素，并传入新的元素e（如果用extractMax后再add，相当于两次O(logn)操作，所以直接替换最大元素然后再siftDown()）
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

//    // 把任意数据整理成堆的形状——————笨办法是通过遍历数据，交换元素位置
//    public E heapify() {
//
//    }


}
