package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import com.example.logproject.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.Map;

@Data
abstract class PredicateCreator {

    private Root<Log> log;
    private String key;
    private CriteriaBuilder cb;

    abstract public Predicate createPredicate(Map<String, String> logDTO, CriteriaBuilder cb) throws ParseException;

    public String getRootKey(String key) {
        return Utils.getRootKey(key);
    }

}
