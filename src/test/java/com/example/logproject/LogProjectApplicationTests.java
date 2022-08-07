package com.example.logproject;

import com.example.logproject.dto.FilePathDTO;
import com.example.logproject.repo.LogRepository;
import com.example.logproject.service.LogServiceImpl;
import com.example.logproject.utils.Utils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LogProjectApplicationTests {

	@Autowired
	LogRepository logRepository;

	@Autowired
	LogServiceImpl service;

	@Test
	public void betweenDatetime() {
		LocalDateTime dateTimeStart = Utils.parseDateToLocalDateTime("2021-01-26 19:20:34.298");
		LocalDateTime dateTimeEnd = Utils.parseDateToLocalDateTime("2021-01-28 22:12:43.405");

		logRepository.findByDatetimeBetween(dateTimeStart, dateTimeEnd)
				.as(StepVerifier::create)
				.expectNextMatches(log -> log.getMessage().contains("delta=1h23s907ms)"))
				.expectNextCount(2)
				.verifyComplete();
	}

	@Test
	public void findAll() {
		logRepository.findAll()
				.as(StepVerifier::create)
				.expectNextCount(48)
				.expectNextMatches(log -> log.getMessage().contains("Process Completed"))
				.verifyComplete();
	}

	@BeforeAll
	public void insertLogs() {
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

	@AfterAll
	public void deleteLogs() {
		logRepository.deleteAll();
	}
}
