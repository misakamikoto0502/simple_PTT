package com.nycu.service;

import com.nycu.mapper.ArticleMapper;
import com.nycu.mapper.BoardMapper;
import com.nycu.mapper.UserMapper;
import com.nycu.pojo.Article;
import com.nycu.pojo.Board;
import com.nycu.pojo.User;
import com.nycu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ArticleService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Article> selectAll(){


        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        //4. 调用方法
        List<Article> articles= mapper.selectAll();

        sqlSession.close();

        return articles;
    }
    public void add(Article article){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //4. 调用方法
        articleMapper.add(article);
        sqlSession.commit();


        sqlSession.close();

    }
    public List<Article> selectByBid(Integer bid){


        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        //4. 调用方法
        List<Article> articles= mapper.selectByBid(bid);

        sqlSession.close();

        return articles;
    }
    public Article selectById(Integer id){


        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        //4. 调用方法
        Article article= mapper.selectById(id);

        sqlSession.close();

        return article;
    }
    public void deleteById(int id){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        //4. 调用方法
        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    public void updateById(Article article){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

        //4. 调用方法
        articleMapper.updateById(article);
        sqlSession.commit();


        sqlSession.close();

    }
}
