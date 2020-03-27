package algorithm.designMode.factory.method;

public class Test {
    public static void main(String[] args) {
        AbstractFactory huaweiFactory = new HUAWEIFactory();
        AbstractFactory appleFactory = new AppleFactory();
        huaweiFactory.makePhone();
        appleFactory.makePc();
    }
}
