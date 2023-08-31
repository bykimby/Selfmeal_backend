package com.example.SelfMeal.user.domain.dto;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNameDuplicatedResDto {
    private String userName;
    private boolean isDuplicated;
}
