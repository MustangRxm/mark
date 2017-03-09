package me.sonico.dao.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

/**
 * Created by yanfa_4 on 2016-12-05.
 */
public class user extends AbstractBaseRedisDao {

    public void add(){
        Boolean result = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {

                return redisConnection.setNX("d".getBytes(),"".getBytes());
            }
        });
    }
}
