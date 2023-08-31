package com.example.studyproject.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DietDto {
    private Long dietId;
    private float kcalToEat;
    private String availableIngredients;
    private String meal;
    private String inavailableIngredients;
    private String dietDisease;
    private Long userId;
}
