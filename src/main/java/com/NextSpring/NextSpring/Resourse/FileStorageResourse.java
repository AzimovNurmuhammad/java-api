//package com.NextSpring.NextSpring.Resourse;
//
//import com.NextSpring.NextSpring.Service.FileStorageService;
//import com.NextSpring.NextSpring.entity.FileStorage;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/api")
//public class FileStorageResourse{
//
//    private final FileStorageService fileStorageService;
//
//    public FileStorageResourse(FileStorageService fileStorageService) {
//        this.fileStorageService = fileStorageService;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity upload(@RequestParam("file")MultipartFile multipartFile){
//        FileStorage fileStorage = fileStorageService.save(multipartFile);
//        return ResponseEntity.ok(fileStorage);
//    }
//}
//
//
//
//
//
//
//
//
//
////package com.NextSpring.NextSpring.Resourse;
////import com.NextSpring.NextSpring.Service.FileStorageService;
////import com.NextSpring.NextSpring.entity.FileStorage;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////import org.springframework.web.multipart.MultipartFile;
////
////@RestController
////@RequestMapping("/api")
////public class FileStorageResourse {
////
////    private final FileStorageService fileStorageService;
////
////    public FileStorageResourse(FileStorageService fileStorageService) {
////        this.fileStorageService = fileStorageService;
////    }
////
////    @PostMapping("/upload")
////    public ResponseEntity upload(@RequestParam("file")MultipartFile multipartFile){
////        FileStorage fileStorage = fileStorageService.save(multipartFile);
////        return ResponseEntity.ok(fileStorage);
////    }
////}
