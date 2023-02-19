package com.example.localstack.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RequestMapping("/api/v1/swagger")
@RestController
public class SwaggerController {

  @ApiOperation(value = "", hidden = true)
  @GetMapping("/hidden")
  public void method1() {

  }

  @PostMapping("/parameter")
  public void method2(@RequestBody ParameterDto parameter) {

  }

  @Value
  @ApiModel(description = "parameter model")
  public static class ParameterDto {

    @ApiModelProperty(name = "param", value = "param", notes = "param")
    String parameter;
  }

}
