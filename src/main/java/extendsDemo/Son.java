package extendsDemo;

public class Son extends Father{
    public void run(){
        System.out.println("sun run");
    }

    public void run(int a){
        System.out.println(a);
    }

    public void eat(int a){
        System.out.println("sun eat");
    }


    public void cook(){
        //匿名内部类实现多继承
        new Mother().cook();
        //内部类继承第二个类来实现多继承
        Mom m = new Mom();
        m.cook();
    }

    private static class Mom extends Mother{
        @Override
        public void cook() {
            System.out.println("Mom cook");
        }
    }
}
