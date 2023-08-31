package com.example.studyproject.repository;

import com.example.studyproject.domain.UserEntity;
import com.example.studyproject.entity.DietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DietRepository extends JpaRepository<DietEntity,Long> {
}
