package setAndmap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 自定义二分搜索树类
 *
 * @param <E> 这个类型必须有可比较性
 */
public class BinarySearchTree<E extends Comparable<E>> {

    // 私有内部类，存储节点类型，包含一个元素值变量和两个指向节点变量
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {  // 独有构造函数，初始化节点，仅包含元素值，指向节点都为空
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;  // 成员变量，根节点
    private int size; // 成员变量，元素个数

    // 构造函数，构造空二分搜索树
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // 查询二分搜索树元素个数
    public int size() {
        return size;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e,调用递归算法
    public void add2(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else
            add2(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    private void add2(Node node, E e) {
        if (e.equals(node.e)) { // 插入元素等于节点元素，直接返回
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) { // 插入元素小于节点元素，且节点左子树为空，连接左子树节点
            node.left = new Node(e);
            size++;
            return;  // 结束本方法
        } else if (e.compareTo(node.e) > 0 && node.right == null) { // 插入元素大于节点元素，且节点右子树为空，连接右子树节点
            node.right = new Node(e);
            size++;
            return;  // 结束本方法
        }
        if (e.compareTo(node.e) < 0)  // 如果插入元素小于节点元素，但左子树不为空，递归调用函数
            add2(node.left, e); // 调用递归
        else //e.compareTo(node.e) > 0  ----等于在一开始就判断了 // 如果插入元素大于节点元素，但右子树不为空，递归调用函数
            add2(node.right, e); // 调用递归
    }

    // 改进插入元素的方法。向二分搜索树中添加新的元素e,调用递归算法
    public void add(E e) {
        root = add(root, e);
    }

    // 改进插入元素的方法。向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根➡➡➡➡➡➡➡改进方法，省略步骤
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e); // 调用递归
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e); // 调用递归
        return node;
    }

    // 二分搜索树的查询操作,调用递归方法
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 二分搜索树的查询操作
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {  // 查询元素和根节点元素对比:相等
            return true;
        } else if (e.compareTo(node.e) < 0) {  // 查询元素和根节点元素对比:小于，在左子树
            return contains(node.left, e);
        } else { // 查询元素和根节点元素对比:大于，在右子树
            return contains(node.right, e);
        }
    }

    // 二分搜索树的前序遍历，调用递归算法
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树————递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        // if (node != null) {
        System.out.println(node.e); // 先访问节点
        preOrder(node.left); // 递归遍历左子树
        preOrder(node.right); // 递归遍历右子树
        // }
    }

    // 二分搜索树的前序遍历，非递归算法
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }

    }


    // 二分搜索树的中序遍历，调用递归算法
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树————递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left); // 递归遍历左子树
        System.out.println(node.e); // 再访问节点
        inOrder(node.right); // 递归遍历右子树
    }

    // 二分搜索树的后序遍历，调用递归算法
    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树————递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left); // 递归遍历左子树
        postOrder(node.right); // 递归遍历右子树
        System.out.println(node.e); // 最后访问节点
    }


    // 二分搜索树的层序遍历，非递归算法
    public void leveOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 二分搜索树寻找最小元素，调用递归算法
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is Empty.");
        }
        return minimum(root).e;
    }

    // 二分搜索树寻找最小元素的递归算法
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 二分搜索树寻找最小元素的非递归算法
    public E minimumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is Empty.");
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }

    // 二分搜索树寻找最大元素，调用递归算法
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is Empty.");
        }
        return maximum(root).e;
    }

    // 二分搜索树寻找最大元素的递归算法
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // 二分搜索树寻找最大元素的非递归算法
    public E maximumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BinarySearchTree is Empty.");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    // 二分搜索树删除最小值所在节点，返回最小值
    public E removeMin() {
        E minimum = minimum();
        removeMin(root);
        return minimum;
    }

    // 删除以node为根的二分搜索树中的最小节点，同时返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 二分搜索树删除最大值所在节点，返回最大值
    public E removeMax() {
        E maximum = maximum();
        removeMax(root);
        return maximum;
    }

    // 删除以node为根的二分搜索树中的最大节点，同时返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 二分搜索树删除任意节点/元素
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除二分搜索树的任一节点。复杂函数，内部存在递归函数，也存在非递归函数体
     * 删除以node为根的二分搜索树的节点e，返回剩余的根节点
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {  // 在左子树找待删除节点
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) { // 在右子树找待删除节点
            node.right = remove(node.right, e);
            return node;
        } else { //e == node.e  // 待删除节点就是此节点
            if (node.left == null) { // 待删除节点左子树为空
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) { // 待删除节点右子树为空
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            /** 核心代码 */
            // 待删除节点左、右子树都不为空
            Node successor = minimum(node.right);  // 右子树最小节点，后继节点。
            successor.right = removeMin(node.right); // 删除后继节点的根节点的右子树
            successor.left = node.left; // 根节点的左子树

            node.left = node.right = null; // 让node节点和二分搜索数脱离关系
            /** 核心代码 */
            return successor;
            // 此处，为何不需要进行size--操作？原因在于：在removeMin(node.right)操作的时候，已经进行了size--的操作。
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateBSTString(depth) + "null\n");
            return;
        }
        sb.append(generateBSTString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateBSTString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        /////////////////////
        //        5        //
        //       / \       //
        //      3    6     //
        //     / \    \    //
        //    2   4    8   //
        /////////////////////
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int i : nums) {
            bst.add(i);
        }
        bst.preOrder();
        System.out.println("   ");
//        System.out.println(bst);
        bst.preOrderNR();
        System.out.println("   ");
        bst.leveOrder();
        System.out.println("   ");
        System.out.println(bst.maximum());
        System.out.println(bst.minimum());
        System.out.println("   ");
        System.out.println(bst.maximumNR());
        System.out.println(bst.minimumNR());
        System.out.println("   ");
        System.out.println(bst.removeMin());
        System.out.println(bst.removeMax());
        System.out.println(bst);
    }

}
