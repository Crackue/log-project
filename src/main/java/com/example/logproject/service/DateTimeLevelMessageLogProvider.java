package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.repo.LogRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    List<Log> getLog() {
        try(Stream<Log> stream = repo.readAllByDateTimeBetweenPaged(startDate, endDate, pageable)) {
            return stream.filter(log -> !log.equals(level) || !log.getMessage().contains(message)).collect(Collectors.toList());
        }
    }
}
