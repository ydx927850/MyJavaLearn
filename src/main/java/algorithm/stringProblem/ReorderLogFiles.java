package algorithm.stringProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 重新排列日志文件，让字符日志在数字日志之前
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1,log2)->{
            String[] log1s = log1.split(" ", 2);
            String[] log2s = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(log1s[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2s[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int cmp = log1s[1].compareTo(log2s[1]);
                if(cmp!=0){
                    return cmp;
                }else{
                    return log1s[0].compareTo(log2s[0]);
                }
            }
            return isDigit1?(isDigit2?0:1):-1;
        });
        return logs;
    }

}
