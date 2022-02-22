package com.trachoma.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public DataSource dataSource;

    @Test
    void contextLoads() {

        Integer integer = jdbcTemplate.queryForObject("select count(*) from emp", Integer.class);
        log.info("emp表中有{}条数据", integer);
        log.info("数据源是: {}", dataSource.getClass());
    }

}
