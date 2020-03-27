package algorithm.stringProblem;

public class ReverseWords {
    public static String reverseWords(String s){
        s = s.trim();
        int i=0;
        int j=0;
        char[] chars = s.toCharArray();
        while(j<=chars.length){
            if(j == chars.length || chars[j] == ' '){
                reverse(chars,i,j-1);
                i=j+1;
            }
            j++;
        }
        reverse(chars,0,chars.length-1);
        return clearSpaces(chars);
    }

    public static void reverse(char[] s,int i,int j){
        while(i<j){
            swap(s,i++,j--);
        }
    }

    public static void swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static String clearSpaces(char[] s){
        int i=0;
        int j=0;
        while(j<s.length){
            while(j<s.length && s[j] == ' '){
                j++;
            }
            while(j<s.length && s[j] != ' '){
                s[i++] = s[j++];
            }
            while(j<s.length && s[j] == ' '){
                j++;
            }
            if(j<s.length){
                s[i++] = ' ';
            }
        }
        return new String(s,0,i);
    }


    public String reverseWords1(String s) {
        if(s.length() == 0){
            return "";
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        if(ss.length == 0){
            return sb.toString();
        }
        for(int i = ss.length-1;i>=0;i--){
            if(ss[i].length()==0){
                continue;
            }
            sb.append(ss[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = " the sky  is  blue";
        System.out.println(reverseWords(s));
    }
}
