package algorithm.designMode.factory.abstactMode;


public class ApplePC implements PC {
    public ApplePC(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("make a applePC");
    }
}
