package algorithm.designMode.factory.simple;

public class HUAWEIPhone implements Phone {
    public HUAWEIPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("make a HUAWEI Phone");
    }
}
