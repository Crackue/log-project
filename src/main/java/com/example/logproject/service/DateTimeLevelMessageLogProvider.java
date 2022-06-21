package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.repo.LogRepository;
import com.example.logproject.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class DateTimeLevelMessageLogProvider extends LogProvider{

    @Autowired
    LogRepository repo;
    private String level;
    private String message;
    private Date startDate;
    private Date endDate;
    private Pageable pageable;
    @Override
    Iterable<Log> getLog() {
        return repo.findByDateTimeBetweenAndMessageContainingAndLevel(startDate, endDate, message, level, pageable);
    }

    @Override
    void setLogDTO(LogDTO logDTO, Pageable pageable) throws ParseException {
        Date startDate = Utils.parseDate(logDTO.getStartDate());
        Date endDate = Utils.parseDate(logDTO.getEndDate());
        setStartDate(startDate);
        setEndDate(endDate);
        setLevel(logDTO.getLevel());
        setMessage(logDTO.getMessage());
        setPageable(pageable);
    }
}
