package com.example.studyproject.service;


import com.example.studyproject.domain.UserEntity;
import com.example.studyproject.domain.UserDto;
import com.example.studyproject.mapper.UserMapper;
import com.example.studyproject.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;


@Service
public class UserService {
//    @Value("${jwt.secret}")
//    private String SECRET_KEY;
//    public String generateAccessToken(UserEntity user) {
//        return Jwts.builder()
//                .setSubject(user.getUserName())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15분
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String generateRefreshToken(UserEntity user) {
//        return Jwts.builder()
//                .setSubject(user.getUserName())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 24시간
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//    @Transactional//회원가입
//    public UserDto registerUser(UserDto userDto) {
//        if (userRepository.findByUsername(userDto.getUserName()).isPresent()) {
//            throw new RuntimeException("이미 존재하는 회원입니다");
//        }
//
//        UserEntity userEntity = userMapper.toEntity(userDto);
//        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        userEntity.setAccessToken(jwtUtil.generateAccessToken(userDto.getUsername()));
//        userEntity.setRefreshToken(jwtUtil.generateRefreshToken(userDto.getUsername()));
//        UserDto returnDto=userMapper.toDto(userRepository.save(userEntity));
//        return returnDto;
//    }
//
//    //로그인해서 회원여부 확인하고 엑세스, refresh 토큰 발급
//    public UserDto login(UserDto userDto) {
//        UserEntity userEntity = userRepository.findByUsername(userDto.getUsername())
//                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
//
//        if (!passwordEncoder.matches(userDto.getPassword(), userEntity.getPassword())) {
//            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
//        }
//
//        userEntity.setAccessToken(jwtUtil.generateAccessToken(userDto.getUsername()));//엑세스 토큰 생성
//        userEntity.setRefreshToken(jwtUtil.generateRefreshToken(userDto.getUsername()));//refresh 토큰 생성
//        userRepository.save(userEntity);//user에 저
//
//        UserDto returnDto = userMapper.toDto(userEntity);//dto로 반환
//        return returnDto;
//    }
//
//    //accesstoken 만료로 새로 요청되면 refreshtoken으로 access token 발급
//    public String refreshToken(String refreshToken) {
//        if (!jwtUtil.validateRefreshToken(refreshToken)) {
//            throw new RuntimeException("refreshtoken이 유효하지 않습니다");
//        }
//
//        UserEntity userEntity = userRepository.findByRefreshToken(refreshToken)
//                .orElseThrow(() -> new RuntimeException("존재하지 않는 refresh token 입니다."));
//
//        String newAccessToken = jwtUtil.generateAccessToken(userEntity.getUsername());//새로운 accesstoken
//        userEntity.setAccessToken(newAccessToken);
//        userRepository.save(userEntity);
//        return newAccessToken;
//    }
}
//config는 22jpa 16:35
//principal 공부
//jar 파일