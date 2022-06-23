package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

abstract class LogProvider {
    abstract List<Log> getLog() throws ParseException;
    abstract void setLogDTO(com.example.logproject.dto.Log logDTO, Pageable pageable) throws ParseException;

    public boolean isValid(LogDTO logDTO) {
        return true;
    }
}
