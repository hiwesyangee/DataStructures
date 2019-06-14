package com.hiwes.cores.leetcode;

import java.util.TreeSet;  // 基于红黑树实现
/**
 * LeetCode_804:唯一摩尔斯密码词
 *
 * @date 2018.01.09
 */

/**
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.",
 * "....","..",".---","-.-",".-..","--","-.",
 * "---",".--.","--.-",".-.","...","-","..-",
 * "...-",".--","-..-","-.--","--.."]
 */
public class Solutionn804 {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);  // 设'a'为初始偏移量
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
