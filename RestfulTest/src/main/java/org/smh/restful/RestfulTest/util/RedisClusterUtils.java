package org.smh.restful.RestfulTest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class RedisClusterUtils {

    @Autowired
    private JedisCluster jedisCluster;

    public String getValueByKey(String key) {
        return jedisCluster.get(key);
    }

    public void setValueByKey(String key, String value) {

        jedisCluster.set(key, value);

    }

}
