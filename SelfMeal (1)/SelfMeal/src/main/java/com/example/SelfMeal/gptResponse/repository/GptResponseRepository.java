package com.example.SelfMeal.gptResponse.repository;

import com.example.SelfMeal.gptResponse.entity.GptResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface GptResponseRepository extends JpaRepository<GptResponseEntity,Long> {
    List<GptResponseEntity> findByUserIdAntDietNameContaining(Long userId, String keyword);
    List<GptResponseEntity> findByUserId(Long userId);
    List<GptResponseEntity> findAllByOrderByLikesDesc(Pageable pageable);
}
