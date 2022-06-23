package com.example.logproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class LogDTO_V2 implements Log{
    List<String> keywords;
    List<String> columnNames;
}
