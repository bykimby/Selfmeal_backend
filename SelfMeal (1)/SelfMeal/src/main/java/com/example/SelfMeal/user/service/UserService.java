package com.example.SelfMeal.user.service;




import com.example.SelfMeal.user.domain.dto.*;
import com.example.SelfMeal.user.domain.entity.UserEntity;
import com.example.SelfMeal.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> getUserByUserId(Long userId){
        Optional<UserEntity> userEntity=userRepository.findById(userId);
        return userEntity;
    }
    @Override
    @Transactional(readOnly=true)
    public UserNameDuplicatedResDto isDuplicatedUser(UserNameDuplicatedReqDto userNameDuplicatedReqDto){
        Boolean isDuplicated=userRepository.findByUserName(userNameDuplicatedReqDto.getUserName()).isPresent();
        //isDuplicated ==false 는 없는 것
        return UserNameDuplicatedResDto.builder()
                .userName(userNameDuplicatedReqDto.getUserName())
                .isDuplicated(isDuplicated)
                .build();
    }

    @Override
    @Transactional
    public LoginResDto login(LoginReqDto loginReqDto){
        UserEntity userEntity=userRepository.findByUserName(loginReqDto.getUserName()).orElseThrow(UserDoesNotExistException::new);
        return LoginResDto.builder()
                .userId(userEntity.getId())
                .token(tokenProvider.createToken(userEntity.getUserName()))
            .build();
    }

    @Override
    @Transactional
    public RegisterResDto register(RegisterReqDto registerReqDto){

    }
}
//config는 22jpa 16:35
//principal 공부
//jar 파일