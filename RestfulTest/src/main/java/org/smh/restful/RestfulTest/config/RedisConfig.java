package org.smh.restful.RestfulTest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:redis.properties")
@ConfigurationProperties(prefix = "restful.redis")
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;
    private int maxIdle;
    private long maxWaitMillis;
    private String password;
    private boolean blockWhenExhausted;
    private int maxTotal;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    @Bean
    public JedisPool jedisPoolFactory() {

        System.out.println("start to init jedis");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);


        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }


    @Bean
    public JedisCluster initJedisCluster(){

        System.out.println("start to init jedis cluster ");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);

        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.198.128", 6379));
        nodes.add(new HostAndPort("192.168.198.128", 6380));
        nodes.add(new HostAndPort("192.168.198.128", 6381));
        nodes.add(new HostAndPort("192.168.198.129", 6382));
        nodes.add(new HostAndPort("192.168.198.129", 6383));
        nodes.add(new HostAndPort("192.168.198.129", 6384));

        JedisCluster jedisCluster = new JedisCluster(nodes, 1500, 1500, 10, "123456", jedisPoolConfig);
//        JedisCluster jedisCluster = new JedisCluster(nodes, jedisPoolConfig);
        return jedisCluster;
    }
}
