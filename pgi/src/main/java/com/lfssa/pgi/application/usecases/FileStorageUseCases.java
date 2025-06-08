package com.lfssa.pgi.application.usecases;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageUseCases {
    void init();

    String store(MultipartFile file);

    Resource getByPath(String filename);
}
