package com.example.SelfMeal.user.repository;


import com.example.SelfMeal.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {//회원 정보 저장
//    Optional<UserEntity> findByRefreshToken(String refreshToken);
//    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findById(Long userId);
    Optional<UserEntity> findByUserName(String userName);
}
