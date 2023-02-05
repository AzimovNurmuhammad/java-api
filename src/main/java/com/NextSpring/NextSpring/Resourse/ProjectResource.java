//package com.NextSpring.NextSpring.Resourse;
//
//import com.NextSpring.NextSpring.Service.ProjectService;
//import com.NextSpring.NextSpring.entity.Shop;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ProjectResource {
//
//    private final ProjectService projectService;
//
//    public ProjectResource(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    @PostMapping("/shops")
//    public ResponseEntity create(@RequestBody Shop shop){
//        Shop result = projectService.save(shop);
//        return ResponseEntity.ok(result);
//    }
//
//    @PutMapping("/shops")
//    public ResponseEntity update (@RequestBody Shop shop) {
//        if (shop.getId() == null){
//            return ResponseEntity.ok("Error");
//        }
//        Shop result = projectService.save(shop);
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping("shops/{id}")
//    public ResponseEntity<Shop> getOne(@PathVariable Long id){
//        Shop result = projectService.findById(id);
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping("/shops")
//    public ResponseEntity getAll(@RequestParam String name,
//                                 @RequestParam String price){
//        List<Shop> shops = projectService.findAll(name, price);
//        return ResponseEntity.ok(shops);
//    }
//
//    @GetMapping("/shops/find")
//    public ResponseEntity findAllParam(@RequestParam String name){
//        List<Shop> resoult = projectService.findAllParam(name);
//        return ResponseEntity.ok(resoult);
//    }
//
//    @DeleteMapping("/shops/{id}")
//    public ResponseEntity delete(@PathVariable Long id){
//        projectService.delete(id);
//        return ResponseEntity.ok("The line is off");
//    }
//
//}