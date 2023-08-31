package com.example.SelfMeal.gptResponse.mapper;


import com.example.SelfMeal.diet.dto.DietDto;
import com.example.SelfMeal.diet.entity.DietEntity;
import com.example.SelfMeal.diet.mapper.DietMapper;
import com.example.SelfMeal.gptResponse.dto.GptResponseDto;
import com.example.SelfMeal.gptResponse.entity.GptResponseEntity;
import com.example.SelfMeal.diet.service.DietService;
import org.springframework.stereotype.Component;

@Component
public class GptResponseMapper {

    private final DietService dietService;
    private final DietMapper dietMapper;
    public GptResponseMapper(DietService dietService,DietMapper dietMapper) {
        this.dietService = dietService;
        this.dietMapper=dietMapper;
    }

    public GptResponseDto toDto(GptResponseEntity gptResponseEntity) {
        GptResponseDto gptResponseDto = new GptResponseDto();
        gptResponseDto.setGptResponseId(gptResponseEntity.getGptResponseId());
        gptResponseDto.setDietName(gptResponseEntity.getDietName());
        gptResponseDto.setDietRecipe(gptResponseEntity.getDietRecipe());
        gptResponseDto.setDietKcal(gptResponseEntity.getDietKcal());
        gptResponseDto.setDietIngredients(gptResponseEntity.getDietIngredients());
        gptResponseDto.setUserId(gptResponseEntity.getUserIdFromDiet());
        gptResponseDto.setDietId(gptResponseDto.getDietId());
        return gptResponseDto;
    }

    public GptResponseEntity toEntity(GptResponseDto gptResponseDto) {
        GptResponseEntity gptResponseEntity = GptResponseEntity.builder()
                .gptResponseId(gptResponseDto.getGptResponseId())
                .dietName(gptResponseDto.getDietName())
                .dietRecipe(gptResponseDto.getDietRecipe())
                .dietRecipe(gptResponseDto.getDietRecipe())
                .dietKcal(gptResponseDto.getDietKcal())
                .dietIngredients(gptResponseDto.getDietIngredients())
                .build();
        DietDto dietDto=dietService.getByUserId(gptResponseDto.getUserId()).get();
        DietEntity dietEntity=dietMapper.toEntity(dietDto);
        gptResponseEntity.setDiet(dietEntity);
        return gptResponseEntity;
    }
}
