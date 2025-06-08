package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.FileStorageUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/file-storage")
public class FileStorageController {
    @Autowired
    private FileStorageUseCases useCases;

    @GetMapping()
    public ResponseEntity<Resource> getFileByPath(@RequestParam String filename) {
        Resource response = useCases.getByPath(filename);
        return ResponseEntity.ok(response);
    }
}
