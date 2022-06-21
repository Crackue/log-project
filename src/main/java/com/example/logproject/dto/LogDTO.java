package com.example.logproject.dto;

import lombok.Data;

@Data
public class LogDTO {
    private String message;
    private String level;
    private String startDate;
    private String endDate;
}
