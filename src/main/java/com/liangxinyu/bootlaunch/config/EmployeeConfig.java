package com.liangxinyu.bootlaunch.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource(name="employee.properties",value = "classpath:employee.properties",encoding = "UTF-8")
@ConfigurationProperties(prefix = "employee")
@Data
public class EmployeeConfig {
    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeName;
    @Value("#{'${employee.names}'.split(',')[0]}")
    private String firstName;
    @Value("#{systemProperties['java.home']}")
    private String javaHome;
}
