package com.skillbridge.config;
import com.skillbridge.model.ServiceListing;import com.skillbridge.repo.ServiceRepository;
import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;
@Configuration public class DataSeeder {
 @Bean CommandLineRunner seed(ServiceRepository repo){return args->{if(repo.count()==0){
 repo.save(new ServiceListing("Modern landing page for your startup","Web Development","Aarav Mehta",1499,"4 days","Responsive landing page with clean UI."));
 repo.save(new ServiceListing("Instagram posts & brand kit","Graphic Design","Riya Shah",599,"2 days","A cohesive set of social media creatives."));
 repo.save(new ServiceListing("Python automation for repetitive tasks","Programming","Dev Patel",999,"3 days","Automate repetitive data tasks."));
 }};}
}
