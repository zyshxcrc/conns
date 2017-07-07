package dao.impl;

import dao.UserDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/28.
 */
@Component
public class UserDaoImpl implements UserDAO {
    @Autowired
    private RedisTemplate<Serializable,Serializable> redisTemplate;
    public void saveUser( User user){
    }
    public User getUser(int id) {
        return new User();
    }
}
