package algorithm.designMode.factory.simple;

public class ApplePhone implements Phone {
    public ApplePhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("make a applePhone");
    }
}
