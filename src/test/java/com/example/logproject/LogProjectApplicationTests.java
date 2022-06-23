package com.example.logproject;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
class LogProjectApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		LogDTO logDTO = new LogDTO();
		logDTO.setLevel("INFO");
		logDTO.setMessage("BLABLABLA");

		ObjectMapper oMapper = new ObjectMapper();
		Map<String, String> log = oMapper.convertValue(logDTO, Map.class);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Log> cq = cb.createQuery(Log.class);
		Root<Log> log_ = cq.from(Log.class);
		Class clazz = log_.get("dateTime").getJavaType();
		cq.select(log_);
		log.get("dateTime");

		Assert.isTrue(true, "");
	}

}
