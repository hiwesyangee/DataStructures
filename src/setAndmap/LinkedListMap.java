package setAndmap;

import java.util.ArrayList;

/**
 * 自定义链表映射
 *
 * @param <K>
 * @param <V>
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dumyHead;
    private int size;

    public LinkedListMap() {
        dumyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 辅助函数，根据key寻找其节点
    private Node getNode(K key) {
        Node cur = dumyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dumyHead.next = new Node(key, value, dumyHead.next);
            size++;
        } else {
            node.value = value; // 或抛出异常
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dumyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }


    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;

    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/setAndmap/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> llmap = new LinkedListMap<>();

            for (String word : words) {
                if (llmap.contains(word)) {
                    llmap.set(word, llmap.get(word) + 1);
                } else {
                    llmap.add(word, 1);
                }
            }
            System.out.println("Total different words: " + llmap.getSize());
            System.out.println("Frequency of PRIDE: " + llmap.get("pride"));
            System.out.println("Frequency of Prejudice: " + llmap.get("prejudice"));
            System.out.println("Frequency of OF: " + llmap.get("of"));
        }
    }
}
