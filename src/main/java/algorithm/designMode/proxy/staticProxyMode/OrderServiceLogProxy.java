package algorithm.designMode.proxy.staticProxyMode;

public class OrderServiceLogProxy implements OrderService {
    //这里变成接口
    private OrderService orderService;
    public OrderServiceLogProxy(OrderService orderService){
        this.orderService = orderService;
    }
    @Override
    public void reduceTask() {
        System.out.println("准备减少库存");
        orderService.reduceTask();
        System.out.println("减少库存结束");
    }
}
