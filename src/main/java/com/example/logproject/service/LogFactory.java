package com.example.logproject.service;

import com.example.logproject.dto.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.dto.LogDTO_V2;
import com.example.logproject.mappingRequests.MappingRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class LogFactory {

    @Autowired
    PredicateLogProviderV1 predicateLogProviderV1;

    @Autowired
    PredicateLogProviderV2 predicateLogProviderV2;

    public LogProvider getLogProvider(Log log, Pageable pageable, String map) throws ParseException {
        if (map.equals(MappingRequests.SEARCH_V1)) {
            predicateLogProviderV1.setLogDTO(log, pageable);
            return predicateLogProviderV1;
        } else if (map.equals(MappingRequests.SEARCH_V2)){
            predicateLogProviderV2.setLogDTO(log, pageable);
            return predicateLogProviderV2;
        } else {
            return null;
        }
    }
}
