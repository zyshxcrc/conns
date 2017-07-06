package dao;

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
public class UserDaoImpl {
    @Autowired
    private RedisTemplate<Serializable,Serializable> redisTemplate;
    public void saveUser(final User user){
        redisTemplate.execute((RedisConnection connection)->{
            connection.set(redisTemplate.getStringSerializer().serialize("user.uid." + user.getId()),
                    redisTemplate.getStringSerializer().serialize(user.getName()));
            return null;
        });
    }
    public User getUser(final int id) {
        return redisTemplate.execute((RedisConnection connection)->{
                byte[] key = redisTemplate.getStringSerializer().serialize("user.uid." + id);
                if (connection.exists(key)) {
                    byte[] value = connection.get(key);
                    String name = redisTemplate.getStringSerializer().deserialize(value);
                    User user = new User();
                    user.setName(name);
                    user.setId(id);
                    return user;
                }
                return null;
        });
    }
}
