package com.example.FileExplorer;

import com.example.FileExplorer.Controller.FileWalker;
import com.example.FileExplorer.POJO.FileMetaData;
import com.example.FileExplorer.Service.FileWalkerService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class FileExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileExplorerApplication.class, args);
//		Path path = Paths.get("Z:/iso");
//		FileWalkerService fileWalkerService = new FileWalkerService();
//		try {
//			Files.walkFileTree(path, fileWalkerService);
//		} catch (IOException ex) {
//			Logger.getLogger(FileWalker.class.getName()).log(Level.SEVERE, null, ex);
//		}
	}
}
