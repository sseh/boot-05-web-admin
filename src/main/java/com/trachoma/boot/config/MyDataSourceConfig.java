package com.trachoma.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.mysql.cj.jdbc.Driver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author trachoma
 * @create 2022-02-21 17:16
 */
@Configuration
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        try {
//            dataSource.setFilters("stat,wall");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return dataSource;
    }

    /**
     * 配置druid的监控页
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        return registrationBean;
    }

    /**
     * 配置web监控
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>(webStatFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }
}
