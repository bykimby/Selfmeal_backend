package com.example.SelfMeal.user.domain.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqDto {
    @NotNull
    private String userName;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;
    @NotNull
    private String gender;
    @NotNull
    private int age;
    @NotNull
    private float height;
    @NotNull
    private float currentWeight;
    @NotNull
    private float targetWeight;
    @NotNull
    private LocalDate targetDate;
    @NotNull
    private String disease;
}
