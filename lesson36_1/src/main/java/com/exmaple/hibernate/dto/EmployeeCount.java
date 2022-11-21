package com.exmaple.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeCount {

  private String employee;
  private long count;

}
