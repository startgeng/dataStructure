package com.kevin.datastructure.chapter4.MyStack;

import java.util.Stack;
/**
 *  leetCode算法题
 * @author kevin
 * @version 1.0
 * @date 2020-12-14 14:58
 */
public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '('){
                    return false;
                }
                if (c == ']' && pop != '['){
                    return false;
                }
                if (c == '}' && pop != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("({[]})"));
        System.out.println(new Solution().isValid("([}["));
    }
}
