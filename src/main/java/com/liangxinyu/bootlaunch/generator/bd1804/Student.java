package com.liangxinyu.bootlaunch.generator.bd1804;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private String gender;

    private String major;

    private String grade;

    private static final long serialVersionUID = 1L;
}