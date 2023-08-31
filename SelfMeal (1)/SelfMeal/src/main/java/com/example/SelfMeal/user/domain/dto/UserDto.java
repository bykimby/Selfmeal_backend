package com.example.SelfMeal.user.domain.dto;


import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private String userName;
    private String password;
    private String gender;
    private int age;
    private float height;
    private float currentWeight;
    private float targetWeight;
    private Long targetDate;
    private String disease;
}
