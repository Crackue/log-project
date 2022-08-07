package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.dto.LogDTO_V1;
import com.example.logproject.dto.LogDTO_V2;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LogService {

    public void readAndSaveLog(FilePathDTO filePath) throws IOException, ParseException;

    Flux<Log> getLog(int page, int size, LogDTO_V1 logDTO) throws ParseException;

    Flux<Log> getLog(int page, int size, LogDTO_V2 logDTO) throws ParseException;
}
