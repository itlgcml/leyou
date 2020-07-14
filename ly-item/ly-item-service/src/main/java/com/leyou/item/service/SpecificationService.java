package com.leyou.item.service;

import com.leyou.common.exception.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpecificationService {


    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     * 通过商品分类id查询规格信息
     *
     * @param id
     * @return
     */
    public List<SpecGroup> querySpecGroupByCid(Long id) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(id);
        List<SpecGroup> specGroupList = specGroupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(specGroupList)) {
            throw new LyException(ExceptionEnum.SPEC_NOT_FOUND);
        }
        return specGroupList;
    }

    /**
     * 保存规格信息
     *
     * @param specGroup
     */
    public void saveSpecGroup(SpecGroup specGroup, String way) {
        if (way.equals("PUT")) {
            int i = specGroupMapper.updateByPrimaryKeySelective(specGroup);
            if (i != 1) {
                throw new LyException(ExceptionEnum.SAVE_SPEC_FAILURE);
            }
        } else {
            int i = specGroupMapper.insert(specGroup);
            if (i != 1) {
                throw new LyException(ExceptionEnum.SAVE_SPEC_FAILURE);
            }
        }
    }

    /**
     * 通过id删除规格信息
     *
     * @param id
     */
    public void delSpecGroup(Long id) {
        Example example = new Example(SpecGroup.class);
        example.createCriteria().andEqualTo("id", id);
        int i = specGroupMapper.deleteByExample(example);
        if (i != 1) {
            throw new LyException(ExceptionEnum.DELETE_SPEC_FAILURE);
        }
    }


    /**
     * 通过组id查询规格详细信息
     *
     * @param groupId
     * @return
     */
    public List<SpecParam> querySpecParamByGroupId(Long groupId) {
        Example example = new Example(SpecParam.class);
        example.createCriteria().andEqualTo("groupId", groupId);//第一个参数要与实体类当中的相同，而非表中
        List<SpecParam> specParamList = specParamMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(specParamList)) {
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOUND);
        }
        return specParamList;
    }

    public List<SpecParam> querySpecParamBycId(Long cid) {
        Example example = new Example(SpecParam.class);
        example.createCriteria().andEqualTo("cid", cid);
        List<SpecParam> specParamList = specParamMapper.selectByExample(example);
        return specParamList;
    }
}
