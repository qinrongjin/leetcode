package cn.tiny77.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class A022 {

    public List<String> generateParenthesis(int n) {
        if(n == 1) {
            return Arrays.asList("()");
        }
        else {
            List<String> string = generateParenthesis(n - 1);
            Set<String> set = new HashSet<String>();
            for (String s : string) {
                for(int i = 0; i <= s.length(); i++) {
                    set.add(insert(s, i));
                }
            }
            return set.stream().collect(Collectors.<String>toList());
        }
    }

    private String insert(String s, int i) {
        if(i==0) {
            return "()" + s;
        } else if (i == s.length()) {
            return s + "()";
        } else {
            return s.substring(0, i) + "()" + s.substring(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new A022().generateParenthesis(10));
    }

}
