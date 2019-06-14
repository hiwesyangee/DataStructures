package binarysearchTree;

import java.util.ArrayList;
import java.util.Random;

// 二分搜索树的测试类
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        while (!bst.isEmpty()) {
            numbers.add(bst.removeMin());
        }

        System.out.println(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin Test Completed.");

        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> numbers2 = new ArrayList<>();
        while (!bst.isEmpty()) {
            numbers2.add(bst.removeMax());
        }
        System.out.println(numbers2);
        for (int i = 1; i < numbers2.size(); i++) {
            if (numbers2.get(i - 1) < numbers2.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax Test Completed.");
    }
}
