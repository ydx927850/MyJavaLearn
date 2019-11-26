package algorithm.bitProblem;

import java.security.PrivilegedAction;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {
    private static int reverseBits(int n){
//        return Integer.reverse(n);
        int res = 0;
        for(int i=0;i<32;i++){
            res = res<<1;
            res+=(n&1);
            n = n>>1;
        }
        return res;
    }

}
