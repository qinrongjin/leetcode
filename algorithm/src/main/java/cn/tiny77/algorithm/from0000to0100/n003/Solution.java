package cn.tiny77.algorithm.from0000to0100.n003;

import java.util.HashMap;
import java.util.Map;

class Solution {

        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int start = 0,  maxLength = 0;
            for (int i = 0; i < s.length(); i ++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c) + 1 > start) {
                        start = map.get(c) + 1;
                    }
                }
                int tempLength = i - start + 1;
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }
                map.put(c, i);
            }
            return maxLength;
        }

    }