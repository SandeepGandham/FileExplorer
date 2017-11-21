package com.example.FileExplorer.Service;

import com.example.FileExplorer.POJO.DriveDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

@Service
public class DrivesService {

    public static void showDrives() throws JsonProcessingException {
        File[] drives = File.listRoots();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        for(int i=0;i<drives.length;i++) {
            DriveDetails driveDetails = new DriveDetails();
            driveDetails.setDriveName("Drive " + drives[i]);
            driveDetails.setType(fsv.getSystemTypeDescription(drives[i]));
            driveDetails.setTotalSpace(drives[i].getTotalSpace());
            driveDetails.setFreeSpace(drives[i].getFreeSpace());
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String jsonInString = objectMapper.writeValueAsString(driveDetails);
            System.out.println(jsonInString);
        }
    }
}
