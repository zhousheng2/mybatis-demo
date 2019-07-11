package com.mybatis.test;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.UserDaoImpl;
import com.mybatis.framework.sqlsession.SqlSessionFactory;
import com.mybatis.framework.sqlsession.SqlSessionFactoryBuilder;
import com.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Despriction: TODO
 * @Author: zhousheng
 * @CreatedTime: 2019-07-01 16:17
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class TestMybatisFramework {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        //指定类路径下的全局配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void queryUserById() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User param = new User();
        param.setId(1);
        User user = userDao.queryUserById(param);
        System.out.println("user:"+user);
    }
}
