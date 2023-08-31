package com.example.studyproject.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DietChatDto {
    private Long dietChatId;
    private String dietNameQuery;
    private String dietRecipeQuery;
    private String dietKcalQuery;
    private Long userId;
}
