//package com.NextSpring.NextSpring.entity;
//
//import com.NextSpring.NextSpring.entity.enummration.FileStorageStatus;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import java.io.Serializable;
//
//@Entity
//public class FileStorage implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    private String extension;
//
//    private Long FileSize;
//
//    private String contentType;
//
//    private String hashId;
//
//    private String uploadFolder;
//
//    private FileStorageStatus fileStorageStatus;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getExtension() {
//        return extension;
//    }
//
//    public void setExtension(String extension) {
//        this.extension = extension;
//    }
//
//    public Long getFileSize() {
//        return FileSize;
//    }
//
//    public void setFileSize(Long fileSize) {
//        FileSize = fileSize;
//    }
//
//    public String getContentType() {
//        return contentType;
//    }
//
//    public void setContentType(String contentType) {
//        this.contentType = contentType;
//    }
//
//    public String getHashId() {
//        return hashId;
//    }
//
//    public void setHashId(String hashId) {
//        this.hashId = hashId;
//    }
//
//    public String getUploadFolder() {
//        return uploadFolder;
//    }
//
//    public void setUploadFolder(String uploadFolder) {
//        this.uploadFolder = uploadFolder;
//    }
//
//    public FileStorageStatus getFileStorageStatus() {
//        return fileStorageStatus;
//    }
//
//    public void setFileStorageStatus(FileStorageStatus fileStorageStatus) {
//        this.fileStorageStatus = fileStorageStatus;
//    }
//}