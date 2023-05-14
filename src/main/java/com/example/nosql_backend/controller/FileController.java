package com.example.nosql_backend.controller;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/api")
public class FileController {

    @Autowired
    private Configuration hadoopConfiguration;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/open/{filePath}")
    public ResponseEntity<Resource> displayTextFile(@PathVariable String filePath) throws IOException {
        FileSystem fileSystem = FileSystem.get(hadoopConfiguration);
        Path path = new Path("/input/"+filePath+".txt");
        System.out.println(path);

        if (fileSystem.exists(path)) {
            System.out.println("file exists");
            InputStream inputStream = fileSystem.open(path);
            InputStreamResource resource = new InputStreamResource(inputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        }

        // Return an appropriate response if the file doesn't exist
        System.out.println("file not found");
        return ResponseEntity.notFound().build();
    }
}
