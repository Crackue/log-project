package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.DateTimeDTO;
import com.example.logproject.dto.FilePathDTO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LogService {

    public List<Log> getLogByDateTime(DateTimeDTO dateTime) throws ParseException;

    public List<Log> getLogByLogLevel(String logLevel);

    public List<Log> getLogByMessage(String message);

    public void readAndSaveLog(FilePathDTO filePath) throws IOException, ParseException;
}
