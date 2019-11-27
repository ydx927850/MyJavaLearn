package algorithm.stringProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断有效括号
 * 使用栈来解决
 *
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/27 10:44
 */
public class IsValidBracket {

    private static boolean isValidBracket(String s) {
        Stack<Character> helper = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                helper.push(')');
            }else if(c == '['){
                helper.push(']');
            } else if(c=='{'){
                helper.push('}');
            } else{
                if (helper.isEmpty() || helper.pop()!=c){
                    return false;
                }
            }
        }
        return helper.isEmpty();
    }

    private static boolean isValid2(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> helper = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = helper.isEmpty() ? '#' : helper.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            }else{
                helper.push(c);
            }
        }
        return helper.isEmpty();
    }
}
