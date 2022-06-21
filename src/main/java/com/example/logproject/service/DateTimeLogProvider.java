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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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

    public DateTimeLogProvider(Date startDate, Date endDate, Pageable pageable) {
        super();
    }

    @Override
    protected List<Log> getLog() {
        try(Stream<Log> stream = repo.readAllByDateTimeBetweenPaged(startDate, endDate, pageable)) {
            return stream.collect(Collectors.toList());
        }
    }
}
