package com.nycu.service;

import com.nycu.mapper.ArticleMapper;
import com.nycu.mapper.CommentMapper;
import com.nycu.pojo.Article;
import com.nycu.pojo.Comment;
import com.nycu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CommentService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Comment> selectByAid(Integer aid){


        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);

        //4. 调用方法
        List<Comment> comments= mapper.selectByAid(aid);

        sqlSession.close();

        return comments;
    }
    public void add(Comment comment){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);

        //4. 调用方法
        mapper.add(comment);
        sqlSession.commit();


        sqlSession.close();

    }
}
