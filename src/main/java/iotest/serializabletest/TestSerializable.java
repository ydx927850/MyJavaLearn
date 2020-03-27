package iotest.serializabletest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSerializable {
    public static void main(String[] args) throws Exception {
        A a1 = new A(1,"中国","你好");
        String objectFile = "./file/serializable.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        System.out.println(a2);
    }
    private static class A implements Serializable{
        int x;
        String y;
        transient String z;
        public A(int x,String y,String z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "A{" +
                    "x=" + x +
                    ", y='" + y + '\'' +
                    ", z='" + z + '\'' +
                    '}';
        }
    }
}
