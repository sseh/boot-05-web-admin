package com.trachoma.boot;

import com.trachoma.boot.bean.User;
import com.trachoma.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public DataSource dataSource;

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {

        Integer integer = jdbcTemplate.queryForObject("select count(*) from emp", Integer.class);
        log.info("emp表中有{}条数据", integer);
        log.info("数据源是: {}", dataSource.getClass());
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1L);
        log.info("用户信息：{}", user);
    }

    @Test
    void testRedisTemplate() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("hello", "redis");
        String hello = operations.get("hello");
        String hcn = operations.get("hcn");
        log.info("redis中的值为: {}", hello);
        log.info("redis中的值为: {}", hcn);
        log.info("连接工厂: {}", redisConnectionFactory.getClass());
    }

}
