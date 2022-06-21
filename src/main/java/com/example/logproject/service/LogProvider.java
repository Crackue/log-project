package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

abstract class LogProvider {
    abstract Iterable<Log> getLog();
    abstract void setLogDTO(LogDTO logDTO, Pageable pageable) throws ParseException;

    public boolean isValid(LogDTO logDTO) {
        return true;
    }
}
