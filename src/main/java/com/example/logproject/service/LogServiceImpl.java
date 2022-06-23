package com.example.logproject.service;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.*;
import com.example.logproject.repo.LogRepository;
import com.example.logproject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogFactory logFactory;
    @Autowired
    LogRepository repo;

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

    @Transactional
    @Override
    public List<Log> getLog(int page, int size, LogDTO logDTO, String map) throws ParseException, IllegalArgumentException {
        Sort sort = Sort.by("dateTime");
        Pageable pageable = PageRequest.of(page, size, sort);
        return getLog(pageable, logDTO, map);
    }

    @Transactional
    @Override
    public List<Log> getLog(int page, int size, LogDTO_V2 logDTO, String map) throws ParseException, IllegalArgumentException {
        Sort sort = Sort.by("dateTime");
        Pageable pageable = PageRequest.of(page, size, sort);
        return getLog(pageable, logDTO, map);
    }

    private List<Log> getLog(Pageable pageable, com.example.logproject.dto.Log log, String map) throws ParseException {
        LogProvider logProvider = logFactory.getLogProvider(log, pageable, map);
        return logProvider.getLog();
    }
}
