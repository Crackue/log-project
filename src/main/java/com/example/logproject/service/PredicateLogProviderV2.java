package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.repo.LogDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PredicateLogProviderV2 extends LogProvider{

    Map<String, List<String>> criterions = new HashMap<>();
    Pageable pageable;
    @Autowired
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
