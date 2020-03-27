package algorithm.designMode.proxy.dynamicProxyMode.jdkMode;

public class OrderServiceImpl implements OrderService {
    @Override
    public void reduceTask() {
        System.out.println("库存减一");
    }
}
