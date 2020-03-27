package algorithm.designMode.proxy.dynamicProxyMode.jdkMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicPermissionProxy implements InvocationHandler {
    //需要被代理的对象，预先并不知道，所以是Object
    private Object target;
    public DynamicPermissionProxy(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进行权限验证");
        //使用反射来调用真正的业务逻辑
        return method.invoke(target, args);
    }
}
