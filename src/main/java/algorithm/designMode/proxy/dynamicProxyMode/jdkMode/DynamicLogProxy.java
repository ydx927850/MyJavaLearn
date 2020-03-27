package algorithm.designMode.proxy.dynamicProxyMode.jdkMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class DynamicLogProxy implements InvocationHandler {
    private Object target;
    public DynamicLogProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备减少库存");
        method.invoke(target,args);
        System.out.println("减少库存结束");
        return null;
    }
}
