package com.leyou.item.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Spu;
import com.leyou.item.service.BrandService;
import com.leyou.item.service.GoodService;
import com.leyou.item.vo.DPage;
import com.leyou.item.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("spu")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandService brandService;

    /**
     * 将商品spu分页
     * @param page
     * @param rows
     * @param saleable
     * @param key
     * @return
     */
    @RequestMapping("page")
    public ResponseEntity<DPage<List<ItemVo>>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable", defaultValue = "-1") Integer saleable,
            @RequestParam(value = "key", required = false) String key
    ) {
        List<Spu> spuList = goodService.querySpuByPage(key, saleable);
        List<ItemVo> itemVoList = new ArrayList<ItemVo>();
        for (Spu spu : spuList) {
            ItemVo itemVo = new ItemVo();
            itemVo.setId(spu.getId());
            itemVo.setTitle(spu.getTitle());
            String[] categoryList = categoryMapper.lgQueryNameByIds(spu.getCid1(), spu.getCid2(), spu.getCid3());
            String cate = categoryList[0] + "/" + categoryList[1] + "/" + categoryList[2];
            itemVo.setGoodCategory(cate);
            Brand brand = brandService.queryBrandById(spu.getBrand_id());
            itemVo.setBrand(brand.getName());
            itemVoList.add(itemVo);
        }
        DPage dPage = new DPage<>(itemVoList, page, rows);
        return ResponseEntity.ok(dPage);
    }
}
