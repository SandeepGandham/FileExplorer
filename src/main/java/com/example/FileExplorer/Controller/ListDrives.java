package com.example.FileExplorer.Controller;
import com.example.FileExplorer.Service.DrivesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
public class ListDrives {

    public static void main(String[] args) throws JsonProcessingException {
        DrivesService.showDrives();
    }
}
