package com.imooc.ad.index;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonStatus {
    VALID(1, "有效状态"),
    INVALID(0, "无效状态"),
    ;

    private Integer status;
    private String desc;
}
