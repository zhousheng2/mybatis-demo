package com.mybatis.dao;

import com.mybatis.framework.sqlsession.SqlSession;
import com.mybatis.framework.sqlsession.SqlSessionFactory;
import com.mybatis.pojo.User;

/**
 * @Despriction: TODO
 * @Author: zhousheng
 * @CreatedTime: 2019-07-01 15:46
 * @ModifyBy:
 * @ModifyTime:
 * @ModifyDespriction:
 * @Version: V1.0.0
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User queryUserById(User param) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.queryUserById", param);
        return user;
    }
}
