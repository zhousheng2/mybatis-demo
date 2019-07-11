package com.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2402101862322385072L;

    private Integer id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

}