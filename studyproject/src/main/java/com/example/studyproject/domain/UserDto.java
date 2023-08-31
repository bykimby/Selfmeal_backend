package com.example.studyproject.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long userid;
    private String userName;
    private String password;
    private String gender;
    private int age;
    private float height;
    private float currentWeight;
    private float targetWeight;
    private LocalDate targetDate;
    private String disease;
}
