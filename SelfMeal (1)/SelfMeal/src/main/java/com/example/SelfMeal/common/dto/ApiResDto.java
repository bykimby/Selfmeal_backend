package com.example.SelfMeal.common.dto;

import com.example.SelfMeal.common.constants.ErrorCode;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResDto {
    private final Boolean success;
    private final Integer errorCode;
    private final String message;
    public static ApiResDto of(Boolean success, Integer errorCode, String message) {
        return new ApiResDto(success, errorCode, message);
    }

    public static ApiResDto of(Boolean success, ErrorCode errorCode) {
        return new ApiResDto(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static ApiResDto of(Boolean success, ErrorCode errorCode, Exception e) {
        return new ApiResDto(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static ApiResDto of(Boolean success, ErrorCode errorCode, String message) {
        return new ApiResDto(success, errorCode.getCode(), errorCode.getMessage(message));
    }
}
