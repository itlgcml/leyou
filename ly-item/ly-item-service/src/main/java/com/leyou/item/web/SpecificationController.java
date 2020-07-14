package com.leyou.item.web;

import com.leyou.item.pojo.Category;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    /**
     * 通过商品分类id查询规格信息
     * @param cid
     * @return
     */
    @RequestMapping(value = "groups/{cid}", method = RequestMethod.GET)
    public ResponseEntity<List<SpecGroup>> querySpecGroupByCid(@PathVariable("cid") Long cid) {
        List<SpecGroup> specGroupList = specificationService.querySpecGroupByCid(cid);
        return ResponseEntity.ok(specGroupList);
    }

    /**
     * 保存规格信息
     * @param specGroup
     * @return
     */
    @RequestMapping(value = "insertGroup", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> saveSpecGroup(@RequestBody SpecGroup specGroup,HttpServletRequest request) {
        String way =request.getMethod();
        specificationService.saveSpecGroup(specGroup,way);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 通过id删除规格
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteGroup/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delSpecGroup(@PathVariable("id") Long id) {
        specificationService.delSpecGroup(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 通过组id查询品牌分类
     * @param gid
     * @return
     */
    @RequestMapping(value = "params",method = RequestMethod.GET)
    public ResponseEntity<List<SpecParam>> querySpecParamByGroupId(@RequestParam("gid") Long gid){
        return ResponseEntity.ok(specificationService.querySpecParamByGroupId(gid));
    }

    /**
     * 通过品牌id查询分类品牌
     * @param cid
     * @return
     */
    @RequestMapping(value = "param",method = RequestMethod.GET)
    public ResponseEntity<List<SpecParam>> querySpecParamBycId(@RequestParam("cid") Long cid){
        return ResponseEntity.ok(specificationService.querySpecParamBycId(cid));
    }

}
