package com.vichhaicoder.demo_mybatis.configData;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;


@Configuration
public class ConfigData {
    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/mybatis_demo",
                "postgres",
                "2003"
        );
    }
}
