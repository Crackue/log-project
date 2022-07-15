package com.example.logproject;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.repo.LogRepository;
import com.example.logproject.service.LogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
class LogProjectApplicationTests {

	@Autowired
	LogRepository logRepository;

	@Autowired
	LogServiceImpl service;

	@Test
	public void test1() {
		insertPlayers();
	}

	private void insertPlayers() {
		FilePathDTO filePath = new FilePathDTO();
		filePath.setPath("/Users/rayalekseev/Downloads/standard.log" );
		try {
			service.readAndSaveLog(filePath);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
