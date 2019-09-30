package cn.tiny77.algorithm.h01.t20.n020;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else if(!stack.isEmpty()){
                char cl = stack.pop();
                if(cl == '(' && c != ')' || cl == '[' && c != ']' || cl == '{' && c != '}') {
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.empty();
    }
}