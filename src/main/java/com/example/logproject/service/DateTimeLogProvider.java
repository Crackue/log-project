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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class DateTimeLogProvider extends LogProvider{

    @Autowired
    LogRepository repo;
    private Date startDate;
    private Date endDate;
    private Pageable pageable;

    @Override
    protected Iterable<Log> getLog() {
        try(Stream<Log> stream = repo.readAllByDateTimeBetweenPaged(startDate, endDate, pageable)) {
            Page<Log> page = new PageImpl<>(stream.collect(Collectors.toList()));
            return page;
        }
    }

    @Override
    void setLogDTO(LogDTO logDTO, Pageable pageable) throws ParseException {
        Date startDate = Utils.parseDate(logDTO.getStartDate());
        Date endDate = Utils.parseDate(logDTO.getEndDate());
        setStartDate(startDate);
        setEndDate(endDate);
        setPageable(pageable);
    }
}
