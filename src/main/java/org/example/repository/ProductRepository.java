package org.example.repository;

import feign.Param;
import org.example.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Modifying
    @Query("FROM ProductEntity p1 WHERE p1.content = :content")
    List<ProductEntity> findByAlternative(@Param("content") String content);
}