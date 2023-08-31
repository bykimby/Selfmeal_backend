package com.example.SelfMeal.diet.repository;


import com.example.SelfMeal.diet.entity.DietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface    DietRepository extends JpaRepository<DietEntity,Long> {
    Optional<DietEntity> findByUser_Id(Long userId);
}
