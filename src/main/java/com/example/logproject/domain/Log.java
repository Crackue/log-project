package com.example.logproject.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime")
    Date dateTime;

    @Column(name = "level")
    String level;

    @Column(name = "message", length = 2048)
    String message;
}
