package com.leyou.item.web;


import com.leyou.item.service.CategoryService;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父级商品分类id查询商品分类
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByPid(@RequestParam("pid") Long pid){
        return ResponseEntity.ok(categoryService.queryCategoryListByPid(pid));
    }

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping("all")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.queryAllCategory());
    }




}
