package com.example.localstack.controller;

import com.example.localstack.dto.ImageLinkDto;
import com.example.localstack.dto.UploadResponseDto;
import com.example.localstack.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/v1/file")
@RestController
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  @PostMapping
  @SneakyThrows
  public UploadResponseDto upload(@RequestPart("file") final MultipartFile file) {
    final String key = fileService.uploadFile(file.getName(), file.getInputStream());
    return UploadResponseDto.builder()
      .key(key)
      .build();
  }

  @GetMapping("{key}")
  public ImageLinkDto getLink(final String key) {
    final String link = fileService.getLink(key);
    return ImageLinkDto.builder()
      .url(link)
      .build();
  }

}
