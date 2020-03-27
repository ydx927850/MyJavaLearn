package algorithm.designMode.factory.simple;

import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import org.springframework.aop.framework.adapter.AdvisorAdapter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

public class PhoneFactory {
    public static Phone makePhone(String phoneType){
        if ("HUAWEI".equals(phoneType)){
            return new HUAWEIPhone();
        }
        if("Apple".equals(phoneType)){
            return new ApplePhone();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
