package com.example.studyproject.mapper;

import com.example.studyproject.domain.UserEntity;
import com.example.studyproject.entity.DietChatDto;
import com.example.studyproject.entity.DietChatEntity;
import com.example.studyproject.entity.DietEntity;
import org.springframework.stereotype.Component;

@Component
public class DietChatMapper {
    public DietChatDto toDto(DietChatEntity dietChatEntity){
        DietChatDto dietChatDto=new DietChatDto();
        dietChatDto.setDietChatId(dietChatEntity.getDietChatId());
        dietChatDto.setDietNameQuery(dietChatEntity.getDietNameQuery());
        dietChatDto.setDietRecipeQuery(dietChatEntity.getDietRecipeQuery());
        dietChatDto.setDietKcalQuery(dietChatEntity.getDietKcalQuery());
        dietChatDto.setUserId(dietChatEntity.getUserId());
        return dietChatDto;
    }
    public DietChatEntity toEntity(DietChatDto dietChatDto){
        DietChatEntity dietChatEntity=DietChatEntity.builder()
                .dietChatId(dietChatDto.getDietChatId())
                .dietNameQuery(dietChatDto.getDietNameQuery())
                .dietRecipeQuery(dietChatDto.getDietRecipeQuery())
                .dietKcalQuery(dietChatDto.getDietKcalQuery())
                .userId(dietChatDto.getUserId())
                .build();
        return dietChatEntity;
    }
}
