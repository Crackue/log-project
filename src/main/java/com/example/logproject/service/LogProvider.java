package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.dto.LogDTO_V1;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.text.ParseException;
import java.util.List;

abstract class LogProvider {
    abstract Flux<Log> getLog() throws ParseException;
    abstract void setLogDTO(LogDTO logDTO, Pageable pageable) throws ParseException;

    public boolean isValid(LogDTO_V1 logDTO) {
        return true;
    }
}
