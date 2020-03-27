package util;

import algorithm.listProblem.ListNode;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/7/12 14:33
 */
public class MyUtil {
    /**
     * MD5盐
     */
    private static final String slat = "yandexiang";


    public static void fileCopy(String src,String dest){
        try {
            FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            //读到的字节数
            int cnt = 0;
            while((cnt = in.read(buffer,0,buffer.length))!=-1){
                //-1表示读到文件尾部了
                out.write(buffer,0,cnt);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fastCopyFile(String src,String dest){
        try {
            FileInputStream inputStream = new FileInputStream(src);
            FileChannel inChannel = inputStream.getChannel();
            FileOutputStream outputStream = new FileOutputStream(dest);
            FileChannel outChannel = outputStream.getChannel();
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while(true){
                int i = inChannel.read(buffer);
                if(i==-1){
                    //读完了
                    break;
                }
                //切换读写
                buffer.flip();
                //写入到新文件
                outChannel.write(buffer);
                //清空缓冲区
                buffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFile(File file){
        try{
            InputStreamReader in = new InputStreamReader(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(in);
            while(reader.readLine()!=null){
                String line =reader.readLine();
                System.out.println(line);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 交换数组两个元素
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 整型数i的第k位(最大七位)
     */
    public static int getDigit(int i, int k) {
        return (int) ((i / (Math.pow(10,k-1))) % 10);
    }

    /**
     * 正向输出链表
     * @param node
     */
    public static void printList(ListNode node){
        if (node==null){
            System.out.println("[]");
        }else{
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(node.val));
            while(node.next!=null){
                stringBuilder.append("->").append(String.valueOf(node.next.val));
                node = node.next;
            }
            System.out.println(stringBuilder.toString());
        }
    }

    /**
     * 反向输出链表
     * 1.栈
     * 2.递归
     * @param node
     */
    public static void reversePrintList(ListNode node){
        Stack<ListNode> stack = new Stack<>();
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(stack.pop().val));
        while(!stack.isEmpty()){
            stringBuilder.append("->").append(stack.pop().val);
        }
        System.out.println(stringBuilder.toString());
    }

    public static String md5Encode(String str){
        String base = str+slat;
        return DigestUtils.md5Hex(base);
    }


}
