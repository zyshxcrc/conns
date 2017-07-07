package service.impl;

import domain.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    public List<User> getUserList() {
        List<User> list = userMapper.getUserList();
        return list;
    }

    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    public void updateUserEmailById(String userId, String sex) {
        userMapper.updateUserEmailById(userId, sex);
    }

    public void deleteUserById(String userId) {
        userMapper.deleteUserById(userId);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
