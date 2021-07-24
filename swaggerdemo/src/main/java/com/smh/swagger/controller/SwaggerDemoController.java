package com.smh.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("swagger")
@Api("SWAGGER demo 控制层")
public class SwaggerDemoController {

    @ApiOperation(value = "demo方法")
    @GetMapping("demo")
    public String demo() {
        return "hello swagger";
    }
}
