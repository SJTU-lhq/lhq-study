package com.lhq.springboot3.controller;

import com.lhq.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/5 16:45
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseResult hello() {
        return ResponseResult.newSuccessResult("Hello, World!");
    }
}
