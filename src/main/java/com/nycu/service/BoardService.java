package com.nycu.service;

import com.nycu.mapper.ArticleMapper;
import com.nycu.mapper.BoardMapper;
import com.nycu.pojo.Article;
import com.nycu.pojo.Board;
import com.nycu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BoardService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Board> selectAll(){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

        //4. 调用方法
        List<Board> boards = mapper.selectAll();

        sqlSession.close();

        return boards;
    }
    public void add(Board board){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        //4. 调用方法
        boardMapper.add(board);
        sqlSession.commit();


        sqlSession.close();

    }
}
