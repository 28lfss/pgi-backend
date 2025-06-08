package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.FileStorageUseCases;
import com.lfssa.pgi.infrastructure.config.exceptions.StorageException;
import com.lfssa.pgi.infrastructure.config.filestorage.FileStorageProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageUseCases {
    private final Path rootLocation;

    public FileStorageServiceImpl(FileStorageProperties properties) {
        if (properties.getLocation().trim().isEmpty()) {
            throw new StorageException("File upload location can not be Empty.");
        }
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    public String store(MultipartFile file) throws StorageException {
        try {
            if (file.isEmpty())
                throw new StorageException("Empty file");

            // Extract original file name (sanitize if needed)
            String originalFilename = Paths.get(file.getOriginalFilename()).getFileName().toString();

            // Get file extension (if any)
            String extension = "";
            int dotIndex = originalFilename.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < originalFilename.length() - 1) {
                extension = originalFilename.substring(dotIndex);
                originalFilename = originalFilename.substring(0, dotIndex);
            }

            // Add timestamp
            String timestamp = String.valueOf(System.currentTimeMillis());
            String newFilename = originalFilename + "_" + timestamp + extension;

            // Build full destination path
            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(newFilename)
            ).normalize().toAbsolutePath();

            Files.copy(file.getInputStream(), destinationFile);

            return newFilename;
        } catch (IOException e) {
            throw new StorageException("Store exception", e);
        }
    }

    @Override
    public Resource getByPath(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else throw new StorageException("Could not find this file");
        } catch (MalformedURLException e) {
            throw new StorageException("Could not read file: " + filename, e);
        }
    }
}
