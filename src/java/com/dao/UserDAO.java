package dao;

import domain.User;

/**
 * Created by Administrator on 2017/7/6.
 */
public interface UserDAO {
    void saveUser(User user);
    User getUser(int id);
}
