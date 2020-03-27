package algorithm.designMode.factory.abstactMode;


public class HUAWEIPC implements PC {
    public HUAWEIPC(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("make a HUAWEI PC");
    }
}
