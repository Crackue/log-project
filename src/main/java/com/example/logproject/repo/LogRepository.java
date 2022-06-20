package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    public List<Log> findAllByDateTimeBetween(Date dateTimeStart, Date dateTimeEnd);
    public Page<Log> findByLevel(String level, Pageable pageable);
    public List<Log> findByMessageLike(String message);
}
