package com.nycu.mapper;

import com.nycu.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from tb_article")
    @ResultMap("articleResultMap")
    List<Article> selectAll();

    @Insert("insert into tb_article values(null,#{author},#{title},#{content},null,#{uid},#{bid})")
    void add(Article article);
    @Select("select * from tb_article where board_id=#{bid}")
    @ResultMap("articleResultMap")
    List<Article> selectByBid(Integer bid);
    @Select("select * from tb_article where id=#{id}")
    @ResultMap("articleResultMap")
    Article selectById(Integer id);
    @Delete("delete from tb_article where id =#{id}")
    void deleteById(int id);
    @Update("UPDATE tb_article SET title=#{title}, content=#{content} WHERE id=#{id}")
    @ResultMap("articleResultMap")
    void updateById(Article article);
}
