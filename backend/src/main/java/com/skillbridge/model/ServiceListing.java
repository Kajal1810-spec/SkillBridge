package com.skillbridge.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="services")
public class ServiceListing {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String title;
 @NotBlank private String category;
 @NotBlank private String freelancer;
 @NotNull @Positive private Integer price;
 private String delivery;
 @Column(length=2000) private String description;
 public ServiceListing(){}
 public ServiceListing(String title,String category,String freelancer,Integer price,String delivery,String description){this.title=title;this.category=category;this.freelancer=freelancer;this.price=price;this.delivery=delivery;this.description=description;}
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public String getFreelancer(){return freelancer;} public void setFreelancer(String v){freelancer=v;}
 public Integer getPrice(){return price;} public void setPrice(Integer v){price=v;}
 public String getDelivery(){return delivery;} public void setDelivery(String v){delivery=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
}
