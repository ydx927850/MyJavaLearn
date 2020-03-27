package algorithm.stringProblem;

/**
 * 判断字符串是否是回文的，可以删除一个字符
 */
public class IsPalindromeString {
    public boolean validPalindrome(String s) {
        int delete=1;
        if(s==null || s.length()<2){
            return true;
        }
        int n = s.length();
        int p1=0;
        int p2=n-1;
        while(p1<p2){
            if(s.charAt(p1)!=s.charAt(p2)){
                return isPalindrome(s,p1+1,p2) | isPalindrome(s,p1,p2-1);
            }else{
                p1++;
                p2--;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
