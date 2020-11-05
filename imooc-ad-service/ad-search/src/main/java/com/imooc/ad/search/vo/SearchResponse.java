package com.imooc.ad.search.vo;

import com.imooc.ad.index.creative.CreativeObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
    // Map：adSlotCode -> 一个或多个广告创意。媒体方根据得到的List<Creative>自行展示曝光
    public Map<String, List<Creative>> adSlot2Ads = new HashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Creative {
        private Long adId;
        private String adUrl;
        private Integer width;
        private Integer height;
        private Integer type;
        private Integer materialType;

        /**
         * 展示检测 url
         * 解释：媒体方一旦广告展示，就要调用若干检测url，以便show给广告方或第三方，告诉他们
         * 广告已经展示了
         */
        private List<String> showMonitorUrl =
                Arrays.asList("www.imooc.com", "www.imooc.com");
        /**
         * 点击检测 url
         * 解释：广告一旦点击，调用若干url，以便告诉广告方or第三方广告被点击
         */
        private List<String> clickMonitorUrl =
                Arrays.asList("www.imooc.com", "www.imooc.com");
    }

    public static Creative convert(CreativeObject object) {

        Creative creative = new Creative();
        /*creative.setAdId(object.getAdId());
        creative.setAdUrl(object.getAdUrl());
        creative.setWidth(object.getWidth());
        creative.setHeight(object.getHeight());
        creative.setType(object.getType());
        creative.setMaterialType(object.getMaterialType());*/
        BeanUtils.copyProperties(object, creative);

        return creative;
    }
}
