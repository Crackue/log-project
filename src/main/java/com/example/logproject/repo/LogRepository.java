package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface LogRepository extends ReactiveCrudRepository<Log, Long> {
    @Query(value = "SELECT u FROM Log u WHERE u.datetime BETWEEN ?1 and ?2")
    public Flux<Log> readAllByDatetimeBetweenPaged(Date dateTimeStart, Date dateTimeEnd, Pageable pageable);
    @Query(value = "SELECT u FROM Log u WHERE u.datetime BETWEEN ?1 and ?2 and u.level = ?3")
    public Flux<Log> findByDatetimeLevel(Date dateTimeStart, Date dateTimeEnd, String level, Pageable pageable);

    public Flux<Log> findByDatetimeBetweenAndMessageContaining(Date dateTimeStart, Date dateTimeEnd, String message, Pageable pageable);

    public Flux<Log> findByDatetimeBetweenAndMessageContainingAndLevel(Date dateTimeStart, Date dateTimeEnd, String message, String level, Pageable pageable);

}
