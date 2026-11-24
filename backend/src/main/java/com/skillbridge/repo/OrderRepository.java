package com.skillbridge.repo;
import com.skillbridge.model.ProjectOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface OrderRepository extends JpaRepository<ProjectOrder,Long>{List<ProjectOrder> findByClientEmailIgnoreCaseOrderByCreatedAtDesc(String email);}
