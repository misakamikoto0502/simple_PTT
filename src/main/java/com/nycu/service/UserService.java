package com.nycu.service;

import com.nycu.mapper.UserMapper;
import com.nycu.pojo.User;
import com.nycu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        User user=userMapper.select(username, password);

        sqlSession.close();

        return user;
    }
    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        User u = userMapper.selectByUsername(user.getUsername());
        if(u==null){
            userMapper.add(user);
            sqlSession.commit();
        }



        sqlSession.close();

        return u==null;
    }
}
