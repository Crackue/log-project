package com.example.logproject.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LevelDTO {
    DEBUG("DEBUG"),INFO("INFO"),WARN("WARN"),ERROR("ERROR"),FATAL("FATAL");
    private final String level;
    private LevelDTO(String level) {
        this.level = level;
    };

    public String getLevel() {
        return level;
    }

    public static List<String> getAllLevels() {
        return Arrays.stream(LevelDTO.values()).map(level -> level.getLevel()).collect(Collectors.toList());
    }
}
