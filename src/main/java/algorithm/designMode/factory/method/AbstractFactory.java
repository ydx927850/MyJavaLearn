package algorithm.designMode.factory.method;

import algorithm.designMode.factory.abstactMode.PC;
import algorithm.designMode.factory.simple.Phone;

public abstract class AbstractFactory {
    public abstract Phone makePhone();
    public abstract PC makePc();
}
