package com.ms.pbacklog.repo;

import com.ms.pbacklog.entity.ProductBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface PBRepository extends JpaRepository<ProductBacklog,Long>{
}
