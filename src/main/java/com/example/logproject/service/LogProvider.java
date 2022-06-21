package com.example.logproject.service;

import com.example.logproject.domain.Log;

import java.util.List;

abstract class LogProvider {
    abstract List<Log> getLog();
}
