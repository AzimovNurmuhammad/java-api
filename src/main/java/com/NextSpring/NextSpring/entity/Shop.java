//
//
//package com.NextSpring.NextSpring.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//import java.io.Serializable;
//import java.util.Set;
//
//@Entity
//public class Shop implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @NotNull
////    @NotNull bu name qatori bush bulmasligi uchun java uchun yoziladi
//    @Size(min = 5, max = 150)
////    @Size name ulchamini belgilab beradi java uchun databasega bormastan turib tekshirib beradi
//
//    /*import jakarta.validation.constraints bu kutubxonani ishlatish uchun
//    build.gradle ga (implementation 'org.hibernate.validator:hibernate-validator')
//    ni impliment qilishimiz kerak*/
//    @Column(name = "name", length = 150, unique = true, nullable = false)
////    length = (0 dan 255) oraliqdagi son quyishimiz mumkun. Name dan keyin (,) bilan yoziladi
////    unique = true bu name takrorlanmasligi uchun unique qilib beradi
////    nullable = false bu namedi null bulmasligi uchun
//    /*
//@Colum ichida biz sql da beradigan tepadagi buyruqlarni berib ketishimiz mumkun buni ichidagi buyruqlar databasega tushadigan
//ma'lumot uchun
//    */
//    private String name;
//
//    @Column(name = "price")
//    private String price;
//
//    @ManyToOne
//    private Product product;
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "account_id", unique = true, nullable = false)
//    private Account account;
//
////  unique = true berilgan id qaytarilmasligi uchun beriladi
////  yani 1 marta yozilgan ma'lumot qaytarilmasligi uchun
////  nullable = false bu null bulishini oldini oladi
////
//
//    @OneToMany
//    private Set<Item> items;
//
//    @ManyToMany
//    @JoinTable(
//            name = "dev_shop_project",
//// name ochiladigan jadvalga nom beradi
//            joinColumns = {@JoinColumn(name = "shop_id", referencedColumnName = "id")},
//// joinColumns dasturdi asosida turgan entity class ni berish uchun.
//            inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id")}
////  inverseJoinColumns kengi qushiladigan jadval qushish uchun
//    )
//    private Set<Project> projects;
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
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
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public Set<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(Set<Item> items) {
//        this.items = items;
//    }
//
//    public Set<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(Set<Project> projects) {
//        this.projects = projects;
//    }
//}
