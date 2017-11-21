package com.example.FileExplorer.Service;

import com.example.FileExplorer.POJO.FileMetaData;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


@Service
public class FileWalkerService extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //System.out.format("preVisitDirectory: %s\n", dir);
        return super.preVisitDirectory(dir, attrs);
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.format("visitFile: %s\n", file);
        String[] FileTitle = file.getFileName().toString().split("\\.");
        System.out.println(FileTitle.length);
        FileMetaData fileMetaData=new FileMetaData();
        fileMetaData.setFileName(FileTitle[0]);
        fileMetaData.setContentType(FileTitle[1]);
        fileMetaData.setCreatedTime(attrs.creationTime());
        fileMetaData.setLastAccessTime(attrs.lastAccessTime());
        fileMetaData.setLastModifiedTime(attrs.lastModifiedTime());
        fileMetaData.setSize(attrs.size());
        fileMetaData.setPath(file.toString());
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String jsonInString = objectMapper.writeValueAsString(fileMetaData);
        System.out.println(jsonInString);
        return super.visitFile(file, attrs);
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.format("visitFileFailed: %s\n", file);
        return super.visitFileFailed(file, exc);
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.format("postVisitDirectory: %s\n", dir);
        return super.postVisitDirectory(dir, exc);
    }
}

