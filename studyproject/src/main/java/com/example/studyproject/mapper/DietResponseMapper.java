package com.example.studyproject.mapper;

import com.example.studyproject.entity.DietResponseDto;
import com.example.studyproject.entity.DietResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DietResponseMapper {
    public DietResponseDto toDto(DietResponseEntity dietResponseEntity){
        DietResponseDto dietResponseDto=new DietResponseDto();
        dietResponseDto.setDietResponseId(dietResponseEntity.getDietResponseId());
        dietResponseDto.setDietName(dietResponseEntity.getDietName());
        dietResponseDto.setDietRecipe(dietResponseEntity.getDietRecipe());
        dietResponseDto.setDietKcal(dietResponseEntity.getDietKcal());
        dietResponseDto.setUserId(dietResponseEntity.getUserId());
        dietResponseDto.setLikes(dietResponseEntity.getLikes());
        return dietResponseDto;
    }
    public DietResponseEntity toEntity(DietResponseDto dietResponseDto){
        DietResponseEntity dietResponseEntity= DietResponseEntity.builder()
                .dietResponseId(dietResponseDto.getDietResponseId())
                .dietName(dietResponseDto.getDietName())
                .dietRecipe(dietResponseDto.getDietRecipe())
                .dietKcal(dietResponseDto.getDietKcal())
                .userId(dietResponseDto.getUserId())
                .likes(dietResponseDto.getUserId())
                .build();
        return dietResponseEntity;
    }
}
