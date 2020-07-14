package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_category_brand")
public class CategoryBrand {
    @Id
    private Long categoryId;
    private Long brandId;
}
