package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.DateTimeDTO;
import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.dto.LevelDTO;
import com.example.logproject.repo.LogRepository;
import com.example.logproject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository repo;

    @Override
    public List<Log> getLogByDateTime(DateTimeDTO dateTime) throws ParseException {
        Date startDate = Utils.parseDate(dateTime.getStartDate());
        Date endDate = Utils.parseDate(dateTime.getEndDate());
        return repo.findAllByDateTimeBetween(startDate, endDate);
    }

    @Override
    public List<Log> getLogByLogLevel(String logLevel) {
        return repo.findByLevel(logLevel);
    }

    @Override
    public List<Log> getLogByMessage(String message) {
        return repo.findByMessageLike("%" + message + "%");
    }

    @Override
    public void readAndSaveLog(FilePathDTO filePath) throws IOException, ParseException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = new FileInputStream(filePath.getPath());
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                boolean isError = line.startsWith(LevelDTO.ERROR.getLevel());

                if (isError) {
                    sb.append(line).append("\n\t");
                    line = sc.nextLine();
                    boolean isLevel = LevelDTO.getAllLevels().stream().anyMatch(line::startsWith);
                    while (sc.hasNextLine() && !isLevel) {
                        sb.append(line).append("\n\t");
                        line = sc.nextLine();
                        isLevel = LevelDTO.getAllLevels().stream().anyMatch(line::startsWith);
                    }
                    Log log = Utils.parseLog(sb.toString());
                    repo.save(log);
                    sb = null;

                }
                Log log = Utils.parseLog(line);
                repo.save(log);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
