package trie;

import java.util.TreeMap;

/**
 * 自定义Trie类
 */
// public class Trie<C> {}
public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

    }


    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获取Trie中存储的单词量
    public int getSize() {
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        // 注意，这里很巧妙，此处返回的需要是当前节点是否是一个独立单词，而不是当前节点是否本身是一个单词。
        // panda是一个单词，搜索pan的时候，最后到了n节点，但是n本身并不存储字符n，只有下一个节点和isWord。
        return cur.isWord;
    }

    /**
     * 有待完成，一个查询单词word是否在Trie中的递归方法
     */


    // 查询是否在Trie中有以prefix为前缀的单词——————一个单词也是一个单词的前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    //


}
