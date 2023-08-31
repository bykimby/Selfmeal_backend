package com.example.studyproject.mapper;


import com.example.studyproject.entity.DietDto;
import com.example.studyproject.entity.DietEntity;
import org.springframework.stereotype.Component;

@Component
public class DietMapper {
    public DietDto toDto(DietEntity dietEntity) {
        DietDto dietDto = new DietDto();
        dietDto.setDietId(dietEntity.getDietId());
        dietDto.setKcalToEat(dietEntity.getKcalToEat());
        dietDto.setAvailableIngredients(dietEntity.getAvailableIngredients());
        dietDto.setMeal(dietEntity.getMeal());
        dietDto.setInavailableIngredients(dietEntity.getInavailableIngredients());
        dietDto.setDietDisease(dietEntity.getDietDisease());
        dietDto.setUserId(dietEntity.getUserId());
        return dietDto;
    }

    public DietEntity toEntity(DietDto dietDto) {
        DietEntity dietEntity = DietEntity.builder()
                .dietId(dietDto.getDietId())
                .kcalToEat(dietDto.getKcalToEat())
                .availableIngredients(dietDto.getAvailableIngredients())
                .meal(dietDto.getMeal())
                .inavailableIngredients(dietDto.getInavailableIngredients())
                .dietDisease(dietDto.getDietDisease())
                .userId(dietDto.getUserId())
                .build();
        return dietEntity;
    }
}
