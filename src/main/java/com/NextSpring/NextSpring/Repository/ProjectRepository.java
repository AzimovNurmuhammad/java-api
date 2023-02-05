//package com.NextSpring.NextSpring.Repository;
//
//
//import com.NextSpring.NextSpring.entity.Shop;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ProjectRepository extends JpaRepository<Shop, Long> {
//
////    @Query("select e from Shop e where e.name = 'Nok'")
////    List<Shop>findAll();
//
//
//    @Query("SELECT e from Shop e where e.name = :name and e.price = :price")
//    List<Shop>findAll(@Param("name") String name,
//                      @Param("price") String price);
//
//    List<Shop>findAllByNameAndPrice(String name, String price);
//
//    @Query(value = "SELECT e from Shop e where e.price = :name", nativeQuery = true)
//    List<Shop>findAll(@Param("name") String name);
//
//    List<Shop>findAllByNameLike(String name);
//
//    @Query("select e from Shop e where e.name like :name")
//    List<Shop>findAllByNameLikeJPQL(@Param("name") String name);
//
//    @Query(value = "select e from Shop e where e.name like :name", nativeQuery = true)
//    List<Shop>findAllByNameLikeNative(@Param("name") String name);
//}
