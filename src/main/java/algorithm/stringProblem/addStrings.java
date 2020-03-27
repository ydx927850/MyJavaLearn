package algorithm.stringProblem;

/**
 * 字符串相加
 */
public class addStrings {
    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        int p1=l1-1;
        int p2=l2-1;
        StringBuilder sb = new StringBuilder();
        while(p1>=0 || p2>=0){
            int c1 = p1>=0?num1.charAt(p1)-'0':0;
            int c2 = p2>=0?num2.charAt(p2)-'0':0;
            int c3 = c1+c2+carry;
            if(c3>9){
                carry = 1;
                sb.append(c3%10);
            }else{
                carry = 0;
                sb.append(c3);
            }
            p1--;
            p2--;
        }
        if(carry==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "21235";
        String num2 = "1242";
        System.out.println(addStrings(num1,num2));
    }
}
