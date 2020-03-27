package algorithm.stringProblem;

/**
 * 从1开始打印到n位数的最大值的，比如n=3，则打印1,2,3....999
 * n可能很大，所以不能用int，得用char[]数组
 */
public class PrintNumberN {
    public static void printNumberN(int n){
        if(n<1){
            return;
        }
        char[] number = new char[n];
        printNumber(number,0);
    }

    private static void printNumber(char[] number, int digit) {
        if(digit == number.length){
            print(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[digit] = (char) (i+'0');
            printNumber(number,digit+1);
        }
    }

    private static void print(char[] number) {
        int index=0;
        while(index<number.length && number[index]=='0'){
            index++;
        }
        while(index<number.length){
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printNumberN(4);
    }
}
