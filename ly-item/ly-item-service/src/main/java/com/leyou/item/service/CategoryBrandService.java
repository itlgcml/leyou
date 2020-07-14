package com.leyou.item.service;

import com.leyou.item.mapper.CategoryBrandMapper;
import com.leyou.item.pojo.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryBrandService {

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    public List<CategoryBrand> queryCateBrandById(Long categoryId) {
        CategoryBrand categoryBrand = new CategoryBrand();
        categoryBrand.setCategoryId(categoryId);
        return categoryBrandMapper.select(categoryBrand);
    }
}
