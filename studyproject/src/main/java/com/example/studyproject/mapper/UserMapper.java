package com.example.studyproject.mapper;


import com.example.studyproject.domain.UserDto;
import com.example.studyproject.domain.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUserid(userEntity.getUserid());
        userDto.setAge(userEntity.getAge());
        userDto.setUserName(userEntity.getUserName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setGender(userEntity.getGender());
        userDto.setHeight(userEntity.getHeight());
        userDto.setCurrentWeight(userEntity.getCurrentWeight());
        userDto.setTargetWeight(userEntity.getTargetWeight());
        userDto.setTargetDate(userEntity.getTargetDate());
        userDto.setDisease(userEntity.getDisease());
        return userDto;
    }

    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .userid(userDto.getUserid())
                .age(userDto.getAge())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .gender(userDto.getGender())
                .height(userDto.getHeight())
                .currentWeight(userDto.getCurrentWeight())
                .targetWeight(userDto.getTargetWeight())
                .targetDate(userDto.getTargetDate())
                .disease(userDto.getDisease())
                .build();
        return userEntity;
    }
}
