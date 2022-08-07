package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface LogRepository extends ReactiveCrudRepository<Log, Long> {
    public Flux<Log> findByDatetimeBetween(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
    @Query(value = "SELECT u FROM Log u WHERE u.datetime BETWEEN ?1 and ?2 and u.level = ?3")
    public Flux<Log> findByDatetimeLevel(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd, String level);

}
