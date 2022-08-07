package com.example.logproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "logs")
public class Log {
    @Id
    @Column("id")
    private long id;

    @Column("datetime")
    LocalDateTime datetime;

    @Column("level")
    String level;

    @Column("message")
    String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return datetime.equals(log.datetime) && level.equals(log.level) && message.equals(log.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, level, message);
    }
}
