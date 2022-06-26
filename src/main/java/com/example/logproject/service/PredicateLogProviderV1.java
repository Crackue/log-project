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
public class PredicateLogProviderV1 extends LogProvider{

    private Map<String, String> criterions = new HashMap<>();
    private Pageable pageable;
    @Autowired
    private LogDAO dao;
    @Override
    List<Log> getLog() throws ParseException {
        return dao.findLogsV1(criterions, pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    void setLogDTO(com.example.logproject.dto.Log log, Pageable pageable) throws ParseException {
        ObjectMapper oMapper = new ObjectMapper();
        criterions = oMapper.convertValue(log, Map.class);
        this.pageable = pageable;
    }
}
