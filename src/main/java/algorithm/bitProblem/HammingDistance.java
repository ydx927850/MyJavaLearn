package algorithm.bitProblem;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {
    private static int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        while (x != 0 || y != 0) {
            if ((x & mask) != (y & mask)) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}
