package com.hiwes.cores.leetcode;

import segmenttree.SegmentTree;

/**
 * LeetCode_307:区域和检索 - 数组可变
 * <p>
 * 在处理数组更新的时候，就需要用到线段树这种数据结构，时间复杂度为m*O(logn)级别，效率更高
 *
 * @date 2018.01.24
 */
public class Solution307 {

    private SegmentTree<Integer> segmentTree;

    public Solution307(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data, (a, b) -> (a + b));
        }

    }

    public void update(int index, int val) { // O(logn)
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null.");

        segmentTree.set(index, val);

    }

    public int sumRange(int i, int j) {  // O(logn)
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is null.");

        return segmentTree.query(i, j);
    }

}
