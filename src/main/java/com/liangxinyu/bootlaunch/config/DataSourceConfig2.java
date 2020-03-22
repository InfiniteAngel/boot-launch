/*
package com.liangxinyu.bootlaunch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig2 {
    @Primary
    @Bean(name="uatDataSource")
    @Qualifier("uatDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.uat")
    public DataSource uatDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="sitDataSource")
    @Qualifier("sitDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sit")
    public DataSource sitDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="uatJdbcTemplate")
    public JdbcTemplate uatJdbcTemplate(
            @Qualifier("uatDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean(name="sitJdbcTemplate")
    public JdbcTemplate sitJdbcTemplate(
            @Qualifier("sitDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
*/
