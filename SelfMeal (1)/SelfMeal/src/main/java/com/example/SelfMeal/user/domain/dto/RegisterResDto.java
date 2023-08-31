package com.example.SelfMeal.user.domain.dto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResDto {
    private String userName;
    private String gender;
    private int age;
    private float height;
    private float kcalToEat;
    private float targetWeight;
    private Long targetDate;

}
