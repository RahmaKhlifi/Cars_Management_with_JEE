package Controller;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("user1", "123"));
        users.add(new User("user2", "159"));
    }

    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static boolean authenticateUser(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
