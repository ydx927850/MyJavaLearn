package jvm.dynamicdispatch;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/8/21 19:36
 */
public class DynamicDispatchExample {
    static class Language{}

    static class QQ extends Language{}
    static class Alibaba extends Language{}


    public static class Father{
        public void hardChoice(Language arg){
            System.out.println("father choose language");
        }

        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }

        public void hardChoice(Alibaba arg){
            System.out.println("father choose Alibaba");
        }
    }

    public static class Son extends Father{
        @Override
        public void hardChoice(Language arg){
            System.out.println("son choose language");
        }

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
        Language language = new QQ();
        //实际类型为father，参数静态类型为Language
        father.hardChoice(language);
        language = new Alibaba();
        //实际类型为son，参数静态类型为Language
        son.hardChoice(language);
        //实际类型为Father，静态类型为QQ
        father.hardChoice(new QQ());
        //实际类型为Son，静态类型为Alibaba
        son.hardChoice(new Alibaba());
    }

}
