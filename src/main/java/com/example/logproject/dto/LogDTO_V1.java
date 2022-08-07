package com.example.logproject.dto;

import lombok.Data;

@Data
public class LogDTO_V1 implements LogDTO {
    private String message;
    private String level;
    private String startDatetime;
    private String endDatetime;
}
