package com.example.logproject.service;

import com.example.logproject.dto.LogDTO;
import com.example.logproject.mappingRequests.MappingRequests;
import com.example.logproject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class LogFactory {

    @Autowired
    public DateTimeLogProvider dateTimeLogProvider;
    @Autowired
    public DateTimeLevelLogProvider dateTimeLevelLogProvider;
    @Autowired
    public DateTimeMessageLogProvider dateTimeMessageLogProvider;
    @Autowired
    public DateTimeLevelMessageLogProvider dateTimeLevelMessageLogProvider;

    public LogProvider getLogProvider(LogDTO logDTO, Pageable pageable, String map) throws ParseException {
        if (map.equals(MappingRequests.GET_LOG)) {
            dateTimeLogProvider.setLogDTO(logDTO, pageable);
            return dateTimeLogProvider;
        } else if (map.equals(MappingRequests.GET_LOG_MESSAGE)) {
            dateTimeMessageLogProvider.setLogDTO(logDTO, pageable);
            return dateTimeMessageLogProvider;
        } else if (map.equals(MappingRequests.GET_LOG_LEVEL)) {
            dateTimeLevelLogProvider.setLogDTO(logDTO, pageable);
            return dateTimeLevelLogProvider;
        } else {
            dateTimeLevelMessageLogProvider.setLogDTO(logDTO, pageable);
            return dateTimeLevelMessageLogProvider;
        }
    }
}
