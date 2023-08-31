package com.example.SelfMeal.user.domain.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDto {
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
