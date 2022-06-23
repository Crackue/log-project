package com.example.logproject.dto;

import lombok.Data;

@Data
public class LogDTO implements Log{
    private String message;
    private String level;
    private String startDate;
    private String endDate;
}
