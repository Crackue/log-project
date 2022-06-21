package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    @Query(value = "SELECT u FROM Log u WHERE u.dateTime BETWEEN ?1 and ?2")
    public Stream<Log> readAllByDateTimeBetweenPaged(Date dateTimeStart, Date dateTimeEnd, Pageable pageable);
    @Query(value = "SELECT u FROM Log u WHERE u.dateTime BETWEEN ?1 and ?2 and u.level = ?3")
    public Page<Log> findByDateTimeLevel(Date dateTimeStart, Date dateTimeEnd, String level, Pageable pageable);

    public Page<Log> findByDateTimeBetweenAndMessageContaining(Date dateTimeStart, Date dateTimeEnd, String message, Pageable pageable);

    public Page<Log> findByDateTimeBetweenAndMessageContainingAndLevel(Date dateTimeStart, Date dateTimeEnd, String message, String level, Pageable pageable);

}
