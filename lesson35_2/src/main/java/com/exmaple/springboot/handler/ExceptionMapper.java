package com.exmaple.springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionMapper {

  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(final Exception exception) {
    ModelAndView model = new ModelAndView();
    model.addObject("message", exception.getMessage());
    model.setViewName("error");
    return model;
  }

}
