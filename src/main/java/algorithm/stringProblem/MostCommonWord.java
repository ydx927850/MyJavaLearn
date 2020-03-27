package algorithm.stringProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned){
        paragraph = paragraph.toLowerCase().trim();
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String s:banned){
            set.add(s.toLowerCase());
        }
        String res = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<paragraph.length();i++){
            char c = paragraph.charAt(i);
            if('a'<=c && c<='z'){
                sb.append(c);
            }else{
                res = updateResult(map, set, res, sb);
                sb = new StringBuilder();
            }
        }
        //只有一个单词的情况
        res = updateResult(map, set, res, sb);
        return res;
    }

    private static String updateResult(Map<String, Integer> map, Set<String> set, String res, StringBuilder sb) {
        if(sb.length()!=0){
            if(!set.contains(sb.toString())){
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
                if(map.get(sb.toString())>map.getOrDefault(res,0)){
                    res = sb.toString();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = new String[]{};
        String paragraph = "Bob";
        System.out.println(mostCommonWord(paragraph,s));
    }
}
