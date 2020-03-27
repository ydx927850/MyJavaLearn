package extendsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class TestDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        
        a.show(c);
        b.show(b);
        b.show(c);
        c.show(a);
        c.show(b);
        c.show(new Integer(10));

        List<Integer> list = new ArrayList<>();
    }

    private static class A {
        public void show(B b) {
            System.out.println("b in A");
        }
    }

    private static class B extends A {
        public void show(A a) {
            System.out.println("a in B");
        }

        public void show(C... c) {
            System.out.println("c... in B");
        }

    }

    private static class C extends B {
        public void show(A a) {
            System.out.println("a in c");
        }

        public void show(C c) {
            System.out.println("c in c");
        }

        public void show(Object obj) {
            System.out.println("obj in c");
        }
    }
}
