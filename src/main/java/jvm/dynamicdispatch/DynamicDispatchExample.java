package jvm.dynamicdispatch;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/8/21 19:36
 */
public class DynamicDispatchExample {
    static class QQ{}
    static class Alibaba{}

    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }

        public void hardChoice(Alibaba arg){
            System.out.println("father choose Alibaba");
        }
    }

    public static class Son extends Father{
        @Override
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(Alibaba arg){
            System.out.println("son choose Alibaba");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        //实际类型为Father，静态类型为QQ
        father.hardChoice(new QQ());
        //实际类型为Son，静态类型为Alibaba
        son.hardChoice(new Alibaba());
    }

}
