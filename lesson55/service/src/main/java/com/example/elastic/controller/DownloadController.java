package com.example.elastic.controller;

import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/files")
public class DownloadController {

  @GetMapping
  public ResponseEntity download() {
    final InputStream in = getClass().getResourceAsStream("/download.png");
    return ResponseEntity
      .ok(new InputStreamResource(in));
  }

}
