package algorithm.designMode.factory.method;

import algorithm.designMode.factory.abstactMode.HUAWEIPC;
import algorithm.designMode.factory.abstactMode.PC;
import algorithm.designMode.factory.simple.HUAWEIPhone;
import algorithm.designMode.factory.simple.Phone;

public class HUAWEIFactory extends AbstractFactory {
    @Override
    public Phone makePhone() {
        return new HUAWEIPhone();
    }

    @Override
    public PC makePc() {
        return new HUAWEIPC();
    }
}
