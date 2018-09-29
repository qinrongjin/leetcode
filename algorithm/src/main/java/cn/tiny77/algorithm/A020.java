package cn.tiny77.algorithm;

import java.util.Stack;

public class A020 {

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
