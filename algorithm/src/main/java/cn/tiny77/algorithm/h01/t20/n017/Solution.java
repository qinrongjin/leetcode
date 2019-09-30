package cn.tiny77.algorithm.h01.t20.n017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<String>();
            Map<Character, String[]> map = new HashMap<Character, String[]>();
            map.put('0',new String[]{" "});
            map.put('1',new String[]{});
            map.put('2',new String[]{"a","b","c"});
            map.put('3',new String[]{"d","e","f"});
            map.put('4',new String[]{"g","h","i"});
            map.put('5',new String[]{"j","k","l"});
            map.put('6',new String[]{"m","n","o"});
            map.put('7',new String[]{"p","q","r","s"});
            map.put('8',new String[]{"t","u","v"});
            map.put('9',new String[]{"w","x","y","z"});
            map.put('#',new String[]{});
            map.put('*',new String[]{});
            List<String[]> li = new ArrayList<String[]>();
            for(Character character: digits.toCharArray()){
                String []arr = map.get(character);
                if(arr != null && arr.length > 0){
                    li.add(arr);
                }
            }
            int[] pos = new int[li.size()];
            do {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < pos.length; i++) {
                    int po = pos[i];
                    stringBuilder.append(li.get(i)[po]);
                }
                if(stringBuilder.length()>0)
                    list.add(stringBuilder.toString());
            } while(Add(pos, li));
            return list;
        }

        private boolean Add(int[] pos, List<String[]> li) {
            int i = pos.length - 1;
            for(; i >= 0 ; i--) {
                if(pos[i] < li.get(i).length - 1){
                    break;
                }
            }
            if(i < 0) return false;
            pos[i++]++;
            while (i < pos.length){
                pos[i] = 0;
                i++;
            }
            return true;
        }
    }