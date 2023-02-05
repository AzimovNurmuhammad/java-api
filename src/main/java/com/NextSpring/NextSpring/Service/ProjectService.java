//package com.NextSpring.NextSpring.Service;
//
//
//import com.NextSpring.NextSpring.Repository.ProjectRepository;
//import com.NextSpring.NextSpring.entity.Shop;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProjectService {
//
//    private final ProjectRepository projectRepository;
//
//
//    public ProjectService(ProjectRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }
//
//
//    public Shop save(Shop shop){
//        return projectRepository.save(shop);
//    }
//
//    public Shop findById(Long id) {
//        Optional<Shop> optional = projectRepository.findById(id);
//        if(optional.isPresent()){
//
////  .isPresent() bu method Optional ichidagi method bo'lib null ga tekshirib beradi.
//            return optional.get();
//        }
//        return null;
//    }
//
//    public List<Shop> findAll(String name, String price){
//        List<Shop> shops = projectRepository.findAll(name);
//        return shops;
//    }
//
//    public List<Shop> findAllParam(String name){
//        return projectRepository.findAllByNameLikeJPQL(name);
//    }
//
//    public void delete(Long id){
//        projectRepository.deleteById(id);
//    }
//}
