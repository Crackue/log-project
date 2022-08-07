package com.example.logproject.service;

import com.example.logproject.dto.LogDTO;
import com.example.logproject.dto.LogDTO_V1;
import com.example.logproject.dto.LogDTO_V2;
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

    public LogProvider getLogProvider(LogDTO log, Pageable pageable) throws ParseException {
        if (log instanceof LogDTO_V1) {
            predicateLogProviderV1.setLogDTO(log, pageable);
            return predicateLogProviderV1;
        } else if (log instanceof LogDTO_V2){
            predicateLogProviderV2.setLogDTO(log, pageable);
            return predicateLogProviderV2;
        } else {
            return null;
        }
    }
}
