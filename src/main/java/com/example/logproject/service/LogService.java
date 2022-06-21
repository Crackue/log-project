package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.dto.LogDTO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LogService {

    public void readAndSaveLog(FilePathDTO filePath) throws IOException, ParseException;

    List<Log> getLog(int page, int size, LogDTO logDTO) throws ParseException;
}
