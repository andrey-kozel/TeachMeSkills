package com.example.localstack.service;

import java.io.InputStream;

public interface FileService {

  String uploadFile(final String filename, final InputStream file);

  String getLink(final String key);

}
