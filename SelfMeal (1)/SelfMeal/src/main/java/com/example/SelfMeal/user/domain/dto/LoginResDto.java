package com.example.SelfMeal.user.domain.dto;
import lombok.*;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto {
    private Long userId;
    private String token;
}
