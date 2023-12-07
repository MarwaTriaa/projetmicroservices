package com.microservices.pbessai.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.pbessai.entities.PBItem;

public interface PBItemRepository extends JpaRepository<PBItem, Long>{
}
