package com.lfssa.pgi.infrastructure.config.filestorage;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileStorageProperties {
    private String location = "uploads";
}