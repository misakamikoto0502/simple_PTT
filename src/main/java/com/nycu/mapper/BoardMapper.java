package com.nycu.mapper;
import com.nycu.pojo.Article;
import com.nycu.pojo.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
    @Select("select * from tb_board")
    @ResultMap("boardResultMap")
    List<Board> selectAll();
    @Insert("insert into tb_board values(null,#{boardName})")
    @ResultMap("boardResultMap")
    void add(Board board);
}
