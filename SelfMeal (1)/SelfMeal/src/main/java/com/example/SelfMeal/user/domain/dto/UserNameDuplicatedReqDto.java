package com.example.SelfMeal.user.domain.dto;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNameDuplicatedReqDto {
    @NotNull
    private String userName;
}
