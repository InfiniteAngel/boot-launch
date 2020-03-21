package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.config.EmployeeConfig;
import com.liangxinyu.bootlaunch.model.Family;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CustomYamlTest {
    @Autowired
    Family family;
    @Autowired
    EmployeeConfig employeeConfig;

    @Test
    public void hello(){
        System.out.println(employeeConfig.getEmployeeName());
        log.info(employeeConfig.getFirstName());
        log.info(employeeConfig.getJavaHome());
    }
}
