package com.hiwes.cores.leetcode;

/**
 * LeetCode_203:移除链表元素
 *
 * @date 2018.01.07
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        /** 不涉及虚拟头结点 */
//        while (head != null && head.val == val) {  // 使用while，循环删除多个元素，而不是使用if。
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null; // 删除头结点
//        }
//
//        while (head != null && head.val == val)   // LeetCode官方方式，每次执行都会删除内存空间，所以直接head=head.next;
//            head = head.next;
//
//        if (head == null) { // 如果链表所有元素都等于要删除的某元素，则链表为空
//            return null;
//        }
//        ListNode prev = head;
//        while (prev.next != null) {
//            if (prev.next.val == val) {
////                ListNode delNode = prev.next;
////                prev.next = delNode.next;
////                delNode.next = null;  // 删除链表中间的元素
//                prev.next = prev.next.next;  // 删除prev.next，改为下一个的下一个即可。
//            } else {
//                prev = prev.next;
//            }
//        }
//        return head;
        /** 使用虚拟头结点 */
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;

    }

    // 本地检测代码结果
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode testNode = new ListNode(nums);
        System.out.println(testNode);

        ListNode res = (new Solution203()).removeElements(testNode, 6);
        System.out.println(res);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty.");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头节点的链表信息字符串
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
