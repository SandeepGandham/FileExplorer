package com.example.FileExplorer.Controller;
import com.example.FileExplorer.Service.FileWalkerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * Created by Sandeep on 15th Nov 2017
 */
public class FileWalker {

//    private FileWalkerService fileWalkerService;
//
//    @Autowired
//    FileWalker(FileWalkerService fileWalkerService){
//        this.fileWalkerService=fileWalkerService;
//    }

    public static void main(String[] args) {
        Path path = Paths.get("Z:/iso");
        FileWalkerService fileWalkerService = new FileWalkerService();
        try {
            Files.walkFileTree(path, fileWalkerService);
        } catch (IOException ex) {
            Logger.getLogger(FileWalker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
