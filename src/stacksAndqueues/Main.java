package stacksAndqueues;


import linkedlist.LinkedList;

import java.util.Random;

/**
 * 测试函数
 */
public class Main {

    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位:秒
    private static double testQueue(Queue<Integer> q, int opCount) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long stop = System.nanoTime();

        return (stop - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
