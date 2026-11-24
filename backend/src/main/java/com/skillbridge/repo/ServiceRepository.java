package com.skillbridge.repo;
import com.skillbridge.model.ServiceListing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ServiceRepository extends JpaRepository<ServiceListing,Long>{
 List<ServiceListing> findByCategoryIgnoreCase(String category);
 List<ServiceListing> findByTitleContainingIgnoreCaseOrFreelancerContainingIgnoreCase(String title,String freelancer);
}
