package com.example.SelfMeal.user.mapper;



import com.example.SelfMeal.user.domain.dto.UserDto;
import com.example.SelfMeal.user.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
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
                .id(userDto.getId())
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
