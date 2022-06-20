package com.example.logproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateTimeDTO implements Serializable {
    private String startDate;
    private String endDate;
}
