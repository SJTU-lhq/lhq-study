package com.lhq.springboot2.caffeine;

import com.lhq.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/11/28 17:15
 */
@RestController
@RequestMapping("/caffeine")
public class CaffeineController {
    @Autowired
    private CaffeineService caffeineService;

    @GetMapping("/cache")
    public ResponseResult getCaffeine(@RequestParam("key") String key) {
        return ResponseResult.newSuccessResult(caffeineService.getCache(key));
    }

    @GetMapping("/cache/batch")
    public ResponseResult getCaffeineBatch() {
        String uuid = UUID.randomUUID().toString();
        return ResponseResult.newSuccessResult(caffeineService.getCache(uuid));
    }
}
