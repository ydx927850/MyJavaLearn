package algorithm.designMode.singleton;

import algorithm.designMode.singleton.enumProblem.User;
import algorithm.designMode.singleton.lazy.LazySingletonTest;

public class SingletonTest {
    public static void main(String[] args) {
        User user1 = User.getInstance();
        user1.setName("user1");
        User user2 = User.getInstance();
        user2.setName("user2");
        System.out.println(user1 == user2);
        System.out.println(user1.getName());
        System.out.println(user2.getName());
    }
}
