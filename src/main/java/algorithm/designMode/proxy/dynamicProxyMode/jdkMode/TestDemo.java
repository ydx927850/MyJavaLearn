package algorithm.designMode.proxy.dynamicProxyMode.jdkMode;


import java.lang.reflect.Proxy;

public class TestDemo {
    public static void main(String[] args) {
        OrderService orderServiceimpl = new OrderServiceImpl();
        Class<? extends OrderService> aClass = orderServiceimpl.getClass();

        DynamicLogProxy dynamicLogProxy = new DynamicLogProxy(orderServiceimpl);
        OrderService logProxy = (OrderService) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicLogProxy);

        DynamicPermissionProxy dynamicPermissionProxy = new DynamicPermissionProxy(logProxy);
        OrderService orderService = (OrderService) Proxy.newProxyInstance(aClass.getClassLoader(),
                aClass.getInterfaces(), dynamicPermissionProxy);
        orderService.reduceTask();
    }
}
