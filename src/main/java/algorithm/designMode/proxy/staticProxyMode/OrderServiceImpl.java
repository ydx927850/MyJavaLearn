package algorithm.designMode.proxy.staticProxyMode;

public class OrderServiceImpl implements OrderService {
    @Override
    public void reduceTask() {
        System.out.println("库存减一");
    }
}
