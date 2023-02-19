package com.example.localstack.service;

import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class S3FileService implements FileService {

  final AmazonS3 amazonS3;

  @Override
  public String uploadFile(final String filename, final InputStream file) {
    final ObjectMetadata metadata = new ObjectMetadata();
    final PutObjectRequest request = new PutObjectRequest("test", filename, file, metadata);
    amazonS3.putObject(request);
    return filename;
  }

  @Override
  public String getLink(final String key) {
    final Instant expiredAt = Instant.now().plus(5, ChronoUnit.MINUTES);
    GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest("test", key)
      .withMethod(HttpMethod.GET)
      .withExpiration(Date.from(expiredAt));
    final URL url = amazonS3.generatePresignedUrl(request);
    return url.toString();
  }
}
