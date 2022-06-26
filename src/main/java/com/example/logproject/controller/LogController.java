package com.example.logproject.controller;

import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.dto.LogDTO_V2;
import com.example.logproject.mappingRequests.MappingRequests;
import com.example.logproject.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(MappingRequests.SEARCH_V1)
    public List<Log> getLogs_V1(@PathVariable int page, @PathVariable int size, @RequestBody LogDTO logDTO) {
        try {
            return service.getLog(page, size, logDTO);
        } catch (ParseException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping(MappingRequests.SEARCH_V2)
    public List<Log> getLogs_V2(@PathVariable int page, @PathVariable int size, @RequestBody LogDTO_V2 logDTO) {
        try {
            return service.getLog(page, size, logDTO);
        } catch (ParseException | IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
