package service;

import src.java.com.domain.User;
/**
 * Created by Administrator on 2017/7/6.
 */
public interface UserService {

    List<User> getUserList();

    User getUserById(String userId);

    void updateUserEmailById(String userId, String sex);

    void deleteUserById(String userId);

    void insertUser(User user);
}
