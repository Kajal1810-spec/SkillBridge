package com.skillbridge.controller;
import com.skillbridge.model.*;import com.skillbridge.repo.*;
import jakarta.validation.Valid;import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/api") @CrossOrigin(origins="*")
public class ApiController {
 private final ServiceRepository services; private final OrderRepository orders;
 public ApiController(ServiceRepository s,OrderRepository o){services=s;orders=o;}
 @GetMapping("/health") public Map<String,Object> health(){return Map.of("status","UP","application","SkillBridge API");}
 @GetMapping("/services") public List<ServiceListing> all(@RequestParam(required=false) String category,@RequestParam(required=false) String q){
  if(category!=null&&!category.isBlank())return services.findByCategoryIgnoreCase(category);
  if(q!=null&&!q.isBlank())return services.findByTitleContainingIgnoreCaseOrFreelancerContainingIgnoreCase(q,q);
  return services.findAll();
 }
 @PostMapping("/services") public ResponseEntity<ServiceListing> create(@Valid @RequestBody ServiceListing s){return ResponseEntity.status(HttpStatus.CREATED).body(services.save(s));}
 @GetMapping("/services/{id}") public ServiceListing one(@PathVariable Long id){return services.findById(id).orElseThrow(()->new NoSuchElementException("Service not found"));}
 @PostMapping("/orders") public ResponseEntity<?> createOrder(@RequestBody Map<String,Object> body){
  Long id=Long.valueOf(body.get("serviceId").toString());ServiceListing s=services.findById(id).orElseThrow(()->new NoSuchElementException("Service not found"));
  String email=Objects.toString(body.get("clientEmail"),"").trim();if(email.isBlank())return ResponseEntity.badRequest().body(Map.of("error","clientEmail is required"));
  ProjectOrder o=orders.save(new ProjectOrder(s.getId(),s.getTitle(),email,s.getFreelancer(),s.getPrice()));return ResponseEntity.status(HttpStatus.CREATED).body(o);
 }
 @GetMapping("/orders") public List<ProjectOrder> userOrders(@RequestParam String email){return orders.findByClientEmailIgnoreCaseOrderByCreatedAtDesc(email);}
 @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<?> missing(NoSuchElementException e){return ResponseEntity.status(404).body(Map.of("error",e.getMessage()));}
}
