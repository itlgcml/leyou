package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.CategoryBrand;
import com.leyou.item.service.BrandService;
import com.leyou.item.service.CategoryBrandService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryBrandService categoryBrandService;

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
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "decs", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key
    ) {
        PageResult<Brand> result = brandService.queryBrandByPage(page, rows, sortBy, desc, key);
        return ResponseEntity.status(HttpStatus.OK).body(result);
        //return ResponseEntity.ok(result);
        //以上两种写法效果一样，具体可看HttpStatus类
    }

    /**
     * 新增品牌
     *
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();//没有返回体为build，有返回为body
    }

    /**
     * 通过分类cid查询对应的品牌
     * @param cid
     * @return
     */
    @RequestMapping(value = "cid/{cid}", method = RequestMethod.GET)
    public ResponseEntity<List<Brand>> delSpecGroup(@PathVariable("cid") Long cid) {
        List<CategoryBrand> categoryBrandList = categoryBrandService.queryCateBrandById(cid);
        List<Long> brandIds=new ArrayList<>();
        for (CategoryBrand categoryBrand : categoryBrandList) {
            brandIds.add(categoryBrand.getBrandId());
        }
        List<Brand> brandList = brandService.queryBrandByIds(brandIds);
        return ResponseEntity.status(HttpStatus.OK).body(brandList);
    }
}
