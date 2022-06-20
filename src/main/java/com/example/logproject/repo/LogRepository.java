package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    public List<Log> findAllByDateTimeBetween(Date dateTimeStart, Date dateTimeEnd);
    public List<Log> findByLevel(String level);
    public List<Log> findByMessageLike(String message);
}
