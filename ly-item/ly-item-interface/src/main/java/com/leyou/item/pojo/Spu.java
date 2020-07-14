package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_spu")
public class Spu {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String title;
    private String sub_title;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brand_id;
    private Integer saleable;//是否上架，0下架，1上架
    private Boolean valid;//是否有效，0已删除，1有效
    private Date create_time;
    private Date last_update_time;
}
