package com.example.logproject.service;

import com.example.logproject.dto.LogDTO;
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

    public LogProvider getLogProvider(LogDTO logDTO, Pageable pageable) throws ParseException {
        Date startDate = Utils.parseDate(logDTO.getStartDate());
        Date endDate = Utils.parseDate(logDTO.getEndDate());
        String level = logDTO.getLevel();
        String message = logDTO.getMessage();
        if (level == null && message == null) {
            dateTimeLogProvider.setStartDate(startDate);
            dateTimeLogProvider.setEndDate(endDate);
            dateTimeLogProvider.setPageable(pageable);
            return dateTimeLogProvider;
        } else if (level == null) {
            dateTimeMessageLogProvider.setStartDate(startDate);
            dateTimeMessageLogProvider.setEndDate(endDate);
            dateTimeMessageLogProvider.setMessage(message);
            dateTimeMessageLogProvider.setPageable(pageable);
            return dateTimeMessageLogProvider;
        } else if (message == null) {
            dateTimeLevelLogProvider.setStartDate(startDate);
            dateTimeLevelLogProvider.setEndDate(endDate);
            dateTimeLevelLogProvider.setLevel(level);
            dateTimeLevelLogProvider.setPageable(pageable);
            return dateTimeLevelLogProvider;
        } else {
            dateTimeLevelMessageLogProvider.setStartDate(startDate);
            dateTimeLevelMessageLogProvider.setEndDate(endDate);
            dateTimeLevelMessageLogProvider.setLevel(level);
            dateTimeLevelMessageLogProvider.setMessage(message);
            dateTimeLevelMessageLogProvider.setPageable(pageable);
            return dateTimeLevelMessageLogProvider;
        }
    }
}
