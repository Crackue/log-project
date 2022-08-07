package com.example.logproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class LogDTO_V2 implements LogDTO {
    List<String> keywords;
    List<String> columnNames;
}
