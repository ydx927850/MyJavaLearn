package algorithm.designMode.proxy.dynamicProxyMode.cglibMode;

import algorithm.designMode.proxy.dynamicProxyMode.jdkMode.OrderService;
import algorithm.designMode.proxy.dynamicProxyMode.jdkMode.OrderServiceImpl;

public class TestDemo {
    public static void main(String[] args) {
        DynamicCglibLogProxy dynamicCglibLogProxy = new DynamicCglibLogProxy();
        //这里要传入具体的实现类，而不能是接口了
        OrderServiceImpl orderService = (OrderServiceImpl) dynamicCglibLogProxy.getProxy(new OrderServiceImpl());
        orderService.reduceTask();
    }
}
