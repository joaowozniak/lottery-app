package com.lotteryapp.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestUserDto {

    private String username;
}
