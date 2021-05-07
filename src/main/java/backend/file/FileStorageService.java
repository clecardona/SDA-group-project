package backend.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotBlank;


@Service
    public class FileStorageService {

        @Autowired
        private FileDBRepository fileDBRepository;


    public FileDB store(MultipartFile file) throws IOException {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileDownloadUri =ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/file/")
                .path(file.getName())
                .toUriString(); ;
        FileDB FileDB = new FileDB( fileName, fileDownloadUri,file.getContentType(), file.getBytes(), "0");

            return fileDBRepository.save(FileDB);
        }

       public FileDB getFile(Long id) {
            return fileDBRepository.findById(id).get();
        }

        public Stream<FileDB> getAllFiles() {
            return fileDBRepository.findAll().stream();
        }


    public FileDB findById(Long id) {
        return fileDBRepository.findById(id).get();
    }


    public static class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
    public static void saveImage(MultipartFile imageFile) throws IOException {
        String imageDirectory = System.getProperty("user.dir") + "/UploadImages/";
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory,imageFile.getOriginalFilename());
        Files.write(fileNamePath, imageFile.getBytes());
        /*String folder = "/photos/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path,bytes);*/

    }

    private static void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

}

