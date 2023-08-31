package com.example.studyproject.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DietResponseDto {
    private Long dietResponseId;
    private String dietName;
    private String dietRecipe;
    private String dietKcal;
    private Long userId;
    private Long likes;
}
