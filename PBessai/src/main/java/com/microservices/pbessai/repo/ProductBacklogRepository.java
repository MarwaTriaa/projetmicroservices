package com.microservices.pbessai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.pbessai.entities.ProductBacklog;

public interface ProductBacklogRepository extends JpaRepository<ProductBacklog, Long> {
}
