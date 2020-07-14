package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {


    /**
     *
     * @param id1
     * @param id2
     * @param id3
     * @return
     */
    @Select("SELECT NAME FROM tb_category WHERE id IN (#{id1},#{id2},#{id3})")
    String[] lgQueryNameByIds(@Param("id1") Long id1, @Param("id2") Long id2, @Param("id3") Long id3);

}
