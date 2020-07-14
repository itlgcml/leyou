package com.leyou.item.service;

import com.leyou.common.exception.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private com.leyou.item.mapper.CategoryMapper CategoryMapper;

    /**
     * 根据父级商品分类id查询商品分类
     * @param pid
     * @return
     */
    public List<Category> queryCategoryListByPid(Long pid){
        //里面添加一个对象，就是以对象里面的非空值作为条件
        Category t =new Category();
        t.setParentId(pid);
        List<Category> list = CategoryMapper.select(t);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOND);
        }
        return list;
    }

    /**
     * 查询所有分类
     * @return
     */
    public List<Category> queryAllCategory(){
        return CategoryMapper.selectAll();
    }


}
