package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.dto.LogDTO_V2;
import com.example.logproject.repo.LogDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredicateLogProviderV2 extends LogProvider{

    Map<String, List<String>> criterions = new HashMap<>();
    Pageable pageable;
    LogDAO dao;
    @Override
    List<Log> getLog() throws ParseException {
        return dao.findLogsV2(criterions, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    void setLogDTO(com.example.logproject.dto.Log log, Pageable pageable) throws ParseException {
        ObjectMapper oMapper = new ObjectMapper();
        criterions = oMapper.convertValue(log, Map.class);
        this.pageable = pageable;
    }
}
