package com.example.studyproject.repository;

import com.example.studyproject.domain.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {//회원 정보 저장
    Optional<UserEntity> findByRefreshToken(String refreshToken);
    Optional<UserEntity> findByUsername(String username);
}
