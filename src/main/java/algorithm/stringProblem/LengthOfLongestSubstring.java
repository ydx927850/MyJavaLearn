package algorithm.stringProblem;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length() == 1){
            return s.length();
        }
        Map<Character,Integer> map = new HashMap();
        int res = 0;
        int start = 0;
        map.put(s.charAt(0),0);
        for(int end=1;end<s.length();end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c)+1,start);
            }
            map.put(c,end);
            int tmp = end-start+1;
            res = Math.max(res,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
