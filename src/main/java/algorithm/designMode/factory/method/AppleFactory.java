package algorithm.designMode.factory.method;

import algorithm.designMode.factory.abstactMode.ApplePC;
import algorithm.designMode.factory.abstactMode.PC;
import algorithm.designMode.factory.simple.ApplePhone;
import algorithm.designMode.factory.simple.Phone;

public class AppleFactory extends AbstractFactory {
    @Override
    public Phone makePhone() {
        return new ApplePhone();
    }

    @Override
    public PC makePc() {
        return new ApplePC();
    }
}
