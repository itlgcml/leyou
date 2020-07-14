package com.leyou.item.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品返回列表集合
 */
@Data
public class ItemVo implements Serializable{
    private Long id;
    private String title;
    private String goodCategory;
    private String brand;
}
