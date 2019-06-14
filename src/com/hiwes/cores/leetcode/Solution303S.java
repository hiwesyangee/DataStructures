package com.hiwes.cores.leetcode;

import segmenttree.SegmentTree;

/**
 * LeetCode_303:区域和检索 - 数组不可变
 * 第二种方法
 *
 * @date 2018.01.24
 */
public class Solution303S {

    private SegmentTree<Integer> segmentTree;

    public Solution303S(int[] nums) {
        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        segmentTree = new SegmentTree<>(data, (a, b) -> (a + b));

    }

    public int sumRange(int i, int j) {
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null.");

        return segmentTree.query(i, j);
    }

}
