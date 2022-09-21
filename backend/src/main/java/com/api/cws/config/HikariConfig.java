package com.api.cws.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableTransactionManagement
public class HikariConfig extends com.zaxxer.hikari.HikariConfig {
    @Value("${spring.datasource.hikari.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.hikari.jdbc-url}")
    private String jdbcurl;

    @Value("${spring.datasource.hikari.username}")
    private String username;

    @Value("${spring.datasource.hikari.password}")
    private String password;

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource()
    {
        HikariDataSource hikariDataSource = new HikariDataSource();

        try
        {
            hikariDataSource.setDriverClassName(driverClassName);
            hikariDataSource.setJdbcUrl(jdbcurl);
            hikariDataSource.setUsername(username);
            hikariDataSource.setPassword(password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return hikariDataSource;
    }

}
