package com.example.SelfMeal.gptResponse.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GptResponseDto {
    private Long gptResponseId;
    private String dietName;
    private String dietRecipe;
    private String dietKcal;
    private String dietIngredients;
    private Long userId;
    private Long dietId;
}
