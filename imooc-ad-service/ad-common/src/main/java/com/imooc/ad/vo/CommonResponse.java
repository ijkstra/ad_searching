package com.imooc.ad.vo;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CommonResponse<T> implements Serializable {

    @NonNull private Integer code;
    @NonNull private String message;
    private T data;
}
