package com.service.core.mbti.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQuizRoundRequest {
    private String round;
    private String description;
}
