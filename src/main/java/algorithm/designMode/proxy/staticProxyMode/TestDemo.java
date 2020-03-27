package algorithm.designMode.proxy.staticProxyMode;

public class TestDemo {
    public static void main(String[] args) {
        OrderService orderServiceImpl = new OrderServiceImpl();
        OrderService orderServiceProxy = new OrderServiceLogProxy(orderServiceImpl);
        OrderService orderService = new OrderServicePermissionProxy(orderServiceProxy);
        orderService.reduceTask();
    }
}
