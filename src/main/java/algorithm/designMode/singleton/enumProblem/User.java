package algorithm.designMode.singleton.enumProblem;

/**
 * 使用枚举类实现单例模式
 */
public class User {
    private User(){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static enum Nested{
        INSTANCE;

        private User user;
        private Nested(){
            user = new User();
        }

        private User getUser() {
            return user;
        }
    }

    public static User getInstance(){
        return Nested.INSTANCE.getUser();
    }
}
