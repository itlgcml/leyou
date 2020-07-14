package com.leyou.common.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOND(404,"商品分类未查到"),
    BRAND_NOT_FOUND(404,"品牌不存在"),
    BRAND_INSERT_ERROR(500,"品牌新增失败"),
    UPLOAD_FILE_ERROR(500,"上传文件失败"),
    INVALID_FILE_TYPE(400,"无效文件类型"),
    SPEC_NOT_FOUND(404,"该类型商品规格不存在"),
    DELETE_SPEC_FAILURE(500,"删除商品规格属性失败"),
    SAVE_SPEC_FAILURE(500,"保存商品规格属性失败"),
    SPEC_PARAM_NOT_FOUND(404,"规格详细信息不存在"),
    ;

    private int code;
    private String msg;

}
