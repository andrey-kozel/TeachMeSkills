package com.example.elastic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
public class DownloadController {

  @GetMapping
  public ResponseEntity download() {
    final InputStream in = getClass().getResourceAsStream("/download.png");
    return ResponseEntity
      .ok(new InputStreamResource(in));
  }

  @PostMapping(consumes = {
    MediaType.MULTIPART_FORM_DATA_VALUE,
    MediaType.APPLICATION_OCTET_STREAM_VALUE
  }, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public ResponseEntity upload(
    @RequestPart("file") final MultipartFile file,
    @RequestPart("name") final String name,
    @RequestPart("price") final String price
  ) throws IOException {
    System.out.println(file);
    System.out.println(name);
    System.out.println(price);
    return ResponseEntity
      .ok(new InputStreamResource(file.getInputStream()));
  }

}
