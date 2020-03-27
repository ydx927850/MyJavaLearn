package algorithm.stringProblem.kmp;

/**
 * 字符串模式匹配问题
 * 1.暴力匹配
 * 2.KMP
 */
public class StringMatch {
    /**
     * 暴力匹配算法
     * 采用双指针，不断步进匹配，一旦失配，主串指针回溯，模式串指针归零
     * @param s 主串
     * @param p 模式串
     * @return
     */
    public static int violentMatch(String s,String p){
        if(s.length()==0 && p.length()==0){
            return 0;
        }
        if(s.length()==0 || p.length()==0){
            return -1;
        }
        if(s.length()<p.length()){
            return -1;
        }
        //双指针进行暴力匹配
        int i=0;
        int j=0;
        while(i<s.length() && j<p.length()){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                i = i-j+1;
                j = 0;
            }
        }
        if(j == p.length()){
            //匹配成功
            return i-j;
        }else{
            return -1;
        }
    }

    /**
     * kmp算法
     * 思想就是利用之前匹配过的有效信息，让主串指针永不回退，通过移动模式串指针让模式串尽可能移动到有效的位置上
     * 假设s已经匹配到了i位置，p匹配到j位置
     *  --如果j=-1，或si = pj，i++，j++
     *  --如果j!=-1，且si!=pj，i不变，j=next[j],此举相当于将模式串相对主串向右移动j-next[j]位
     *      --next数组就可以看做是当前字符之前的字符串中，有多长的相同前后缀，比如abcdabd，当前字符为d，那么next[j]=2(ab)
     *      --若next[j]=0/-1,就意味着模式串要跳到首字符
     * 上面步骤就是KMP的整体思路，那么问题就在于如何求next数组
     *
     *
     * @param s 主串
     * @param p 模式串
     * @return
     */
    public static int kmp(String s,String p){
        if(s.length()==0 && p.length()==0){
            return 0;
        }
        if(s.length()==0 || p.length()==0){
            return -1;
        }
        if(s.length()<p.length()){
            return -1;
        }
        int i=0;
        int j=0;
        int[] next = getNext(p);
        while(i<s.length() && j<p.length()){
            if(j==-1 || s.charAt(i) == p.charAt(j)){
                //j=-1代表匹配开始，s[0]!=p[0]，此时模式串跳回首位-1，主串+1，从第二位开始匹配
                i++;
                j++;
            }else{
                //i不变，j跳到next[j]
                j = next[j];
            }
        }
        if(j == p.length()){
            //匹配成功
            return i-j;
        }else{
            return -1;
        }
    }

    /**
     * 求模式串的next数组
     * 假设已经知道next[j] = k，现在求next[j+1]
     * 如果next[j]=k就一位置p[0]-p[k-1] == p[j-k]-p[j-1]
     * 那么就分两种情况：
     *  --p[k] = p[j]:next[j+1] = next[j]+1
     *  --p[k] != p[j]:
     *      --此时就在k长度相同的子串中找前缀，也就是k' = next[k]
     *      --就有p[k-next[k]]-p[k-1] == p[j-next[k]]-p[j-1]
     *      --也有p[0]-p[next[k]-1] == p[k-next[k]]-p[k-1]
     *      --所以就有p[0]-p[next[k]-1] == p[j-next[k]]-p[j-1]
     *          --那么问题就变为了看p[k'] == p[j]?
     *              --若相同，则next[j+1] = next[k]+1
     *              --若不同，进行递归计算即可
     * @param p
     * @return
     */
    private static int[] getNext(String p){
        int[] next= new int[p.length()];
        next[0] = -1;
        next[1] = 0;
        int k;
        for(int j=2;j<p.length();j++){
            //知道next[j-1]求next[j]
            k = next[j-1];
            if(k==-1) {
                next[j] = 0;
                continue;
            }else{
                while(k!=-1 && p.charAt(j-1)!=p.charAt(k)){
                    //若k==-1跳出，就意味着上次已经将最前缀放到了首位，并且首位还是和j-1上的字符还是不等，那么说明此时没有公共前缀，即next[j]=0
                    k = next[k];
                }
                if(k == -1){
                    next[j] = 0;
                }else{
                    next[j] = k+1;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "bbc abcdab abcdabcdabde";
        String p = "abcdabd";
        System.out.println(kmp(s,p));
    }

}
