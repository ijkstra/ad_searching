package com.imooc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.client.SponsorClient;
import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.client.vo.AdPlanGetRequest;
import com.imooc.ad.search.ISearch;
import com.imooc.ad.search.vo.SearchRequest;
import com.imooc.ad.search.vo.SearchResponse;
import com.imooc.ad.vo.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SearchController {
    private final RestTemplate restTemplate;
    private final SponsorClient sponsorClient;
    private final ISearch search;

    @PostMapping("/fetchAds")
    public SearchResponse fetchAds(@RequestBody SearchRequest request) {
        log.info("ad-search: fetchAds -> {}",
                JSON.toJSONString(request));
        return search.fetchAds(request);
    }

    @PostMapping("/getAdPlans")
    @IgnoreResponseAdvice
    public CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlans -> {}", JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    @PostMapping("/getAdPlansByRibbon")
    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    public CommonResponse<List<AdPlan>> getAdPlansByRibbon(@RequestBody AdPlanGetRequest request) {
        log.info("ad-search: getAdPlansByRibbon -> {}", JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class
        ).getBody();
    }
}
