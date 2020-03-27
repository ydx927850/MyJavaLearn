package algorithm.designMode.proxy.staticProxyMode;

public class OrderServicePermissionProxy implements OrderService {
    private OrderService orderService;

    public OrderServicePermissionProxy(OrderService orderService){
        this.orderService = orderService;
    }
    @Override
    public void reduceTask() {
        System.out.println("进行权限验证");
        orderService.reduceTask();
    }
}
