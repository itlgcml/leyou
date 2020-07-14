package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.exception.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Iterator;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 分页查询品牌
     *
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);
        /**
         *SELECT * FROM tb_brand WHERE id LIKE '%1%' OR NAME LIKE '黑'
         ORDER BY id DESC
         */
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%").orEqualTo("letter", key.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderBy = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderBy);
        }
        //查询
        List<Brand> brandList = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brandList)) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //解析分页结果
        PageInfo<Brand> info = new PageInfo<>(brandList);
        return new PageResult<>(info.getTotal(), brandList);
    }


    /**
     * 新增或修改品牌
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if (count != 1) {
            throw new LyException(ExceptionEnum.BRAND_INSERT_ERROR);
        }
        //新增中间表
        for (Long cid : cids) {
            count = brandMapper.insertCategoryBrand(cid, brand.getId());
            if (count != 1) {
                throw new LyException(ExceptionEnum.BRAND_INSERT_ERROR);
            }
        }
    }

    /**
     * 通过品牌id查询实体
     *
     * @param id
     * @return
     */
    public Brand queryBrandById(Long id) {
        Brand brand = new Brand();
        brand.setId(id);
        Brand brandInfo = brandMapper.selectByPrimaryKey(brand);
        return brandInfo;
    }


    public List<Brand> queryBrandByIds(List<Long> ids) {
        Example example = new Example(Brand.class);
        Iterable iterable = ids;
        example.createCriteria().andIn("id",iterable);
        return brandMapper.selectByExample(example);
    }

}
