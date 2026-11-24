package com.skillbridge.model;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="project_orders")
public class ProjectOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long serviceId; private String serviceTitle; private String clientEmail; private String freelancer; private Integer amount; private String status="REQUESTED"; private Instant createdAt=Instant.now();
 public ProjectOrder(){}
 public ProjectOrder(Long serviceId,String serviceTitle,String clientEmail,String freelancer,Integer amount){this.serviceId=serviceId;this.serviceTitle=serviceTitle;this.clientEmail=clientEmail;this.freelancer=freelancer;this.amount=amount;}
 public Long getId(){return id;} public Long getServiceId(){return serviceId;} public String getServiceTitle(){return serviceTitle;} public String getClientEmail(){return clientEmail;} public String getFreelancer(){return freelancer;} public Integer getAmount(){return amount;} public String getStatus(){return status;} public Instant getCreatedAt(){return createdAt;}
}
