package com.hiwes.cores.leetcode;

import java.util.Stack;

/**
 * LeetCode_20:有效的括号
 *
 * @date 2018.01.05
 */
class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topChar = stack.pop();
                    if (c == ')' && topChar != '(') return false;
                    if (c == ']' && topChar != '[') return false;
                    if (c == '}' && topChar != '{') return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isValid("{]"));
        long stop = System.currentTimeMillis();

        System.out.println((stop - start));
    }
}
