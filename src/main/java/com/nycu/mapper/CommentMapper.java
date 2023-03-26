package com.nycu.mapper;

import com.nycu.pojo.Article;
import com.nycu.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Select("select * from tb_comment where article_id=#{aid}")
    @ResultMap("commentResultMap")
    List<Comment> selectByAid(Integer aid);
    @Insert("insert into tb_comment values(null,#{author},#{content},null,#{uid},#{aid})")
    @ResultMap("commentResultMap")
    void add(Comment comment);
}
