package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import com.example.logproject.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class LogDAO {
    @Autowired
    LogRepository logRepository;

    public Flux<Log> findLogsV1(Map<String, String> logDTO, int page, int size) throws ParseException {

        return logRepository.findAll()
                .filter(log -> filterBetweenDatetime(logDTO, log))
                .filter(log -> filterMessage(logDTO, log))
                .filter(log -> filterLevel(logDTO, log))
                .skip(page * size)
                .take(size);
    }

    private boolean filterBetweenDatetime(Map<String, String> logDTO, Log log) {
        String startDatetime = logDTO.get("startDatetime");
        LocalDateTime dateTimeStart = Utils.parseDateToLocalDateTime(startDatetime);
        String endDatetime = logDTO.get("endDatetime");
        LocalDateTime dateTimeEnd = Utils.parseDateToLocalDateTime(endDatetime);
        boolean is = log.getDatetime().isAfter(dateTimeStart) && log.getDatetime().isBefore(dateTimeEnd);
        return (log.getDatetime().isAfter(dateTimeStart) || log.getDatetime().equals(dateTimeStart)) &&
                (log.getDatetime().isBefore(dateTimeEnd) || log.getDatetime().equals(dateTimeEnd));
    }

    private boolean filterMessage(Map<String, String> logDTO, Log log) {
        String message = logDTO.get("message");
        return message != null && !message.isEmpty() ? log.getMessage().contains(message) : true;
    }

    private boolean filterLevel(Map<String, String> logDTO, Log log) {
        String level = logDTO.get("level");
        return level != null && !level.isEmpty() ? log.getLevel().equals(level) : true;
    }

    public Flux<Log> findLogsV2(Map<String, List<String>> logDTO, int page, int size) throws ParseException {
        //TODO
        return null;
    }
}
