package com.hiwes.cores.leetcode;

/**
 * LeetCode_1:两数之和
 *
 * @date 2018.01.03
 */
public class Solution1 {
    /**
     * 跟官方的区别，性能大约在6倍左右，主要原因在于，我在进行数组遍历的时候，两次循环的是所有元素，时间复杂度=O(n^2),
     * 而官方的代码，第一次遍历所有元素，第二次遍历的是剩下的元素，并且一直遍历的是之后的元素，并不对已经遍历的元素再做计算，所以省略了时间。
     */
    // 自己写的
    public static int[] twoSum2(int[] nums, int target) {
        int[] intArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int sum = nums[i] + nums[j];
                    if (sum == target) {
                        intArr[0] = i;
                        intArr[1] = j;
                    }
                }
            }
        }
        return intArr;
    }

    // 官方解题----暴力法，使用数组直接对比结果
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] sumArr = twoSum(nums, target);

        System.out.println("[" + sumArr[0] + ", " + sumArr[1] + "]");

    }
}
