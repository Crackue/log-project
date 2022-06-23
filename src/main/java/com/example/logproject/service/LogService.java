package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.dto.LogDTO_V2;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LogService {

    public void readAndSaveLog(FilePathDTO filePath) throws IOException, ParseException;

    List<Log> getLog(int page, int size, LogDTO logDTO, String map) throws ParseException;

    List<Log> getLog(int page, int size, LogDTO_V2 logDTO, String map) throws ParseException;
}
