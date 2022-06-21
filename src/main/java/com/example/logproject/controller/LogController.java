package com.example.logproject.controller;

import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.mappingRequests.MappingRequests;
import com.example.logproject.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
public class LogController {

    @Autowired
    LogServiceImpl service;

    @PostMapping(MappingRequests.READ_LOG)
    public void readAndSaveLog(@RequestBody FilePathDTO filePath) {
        try {
            service.readAndSaveLog(filePath);
        } catch (ParseException | IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping(MappingRequests.GET_LOG)
    public Page<Log> getLogByDates(@PathVariable int page, @PathVariable int size, @RequestBody LogDTO logDTO) {
        try {
            return service.getLog(page, size, logDTO, MappingRequests.GET_LOG);
        } catch (ParseException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping(MappingRequests.GET_LOG_LEVEL)
    public Page<Log> getLogByLevel(@PathVariable int page, @PathVariable int size, @RequestBody LogDTO logDTO) {
        try {
            return service.getLog(page, size, logDTO, MappingRequests.GET_LOG_LEVEL);
        } catch (ParseException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping(MappingRequests.GET_LOG_MESSAGE)
    public Page<Log> getLogByMessage(@PathVariable int page, @PathVariable int size, @RequestBody LogDTO logDTO) {
        try {
            return service.getLog(page, size, logDTO, MappingRequests.GET_LOG_MESSAGE);
        } catch (ParseException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping(MappingRequests.GET_LOG_LEVEL_MESSAGE)
    public Page<Log> getLogByLevelMessage(@PathVariable int page, @PathVariable int size, @RequestBody LogDTO logDTO) {
        try {
            return service.getLog(page, size, logDTO, MappingRequests.GET_LOG_LEVEL_MESSAGE);
        } catch (ParseException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
