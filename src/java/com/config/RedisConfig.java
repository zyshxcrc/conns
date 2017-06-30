package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/28.
 */
@Configuration
@ComponentScan
public class RedisConfig {
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig());
        jedisConnectionFactory.setUsePool(true);
        return jedisConnectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }

    @Bean
    public RedisTemplate<Serializable,Serializable> redisTemplate(){
        RedisTemplate<Serializable,Serializable> redisTemplate = new RedisTemplate<Serializable,Serializable>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
