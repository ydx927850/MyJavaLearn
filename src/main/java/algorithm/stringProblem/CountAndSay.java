package algorithm.stringProblem;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/10/28 10:12
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {
        String line = "1";
        for(int i=1;i<n;i++){
            line = countAndSayLine(line);
        }
        return line;
    }

    private static String countAndSayLine(String line){
        int count=0;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<line.length();i++){
            if(i==0 || line.charAt(i-1) == line.charAt(i)){
                count++;
            }else{
                str.append(count).append(line.charAt(i-1));
                count = 1;
            }
            if(i==line.length()-1){
                str.append(count).append(line.charAt(i));
            }
        }
        return str.toString();
    }
}
