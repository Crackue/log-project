package com.example.logproject.repo;

import com.example.logproject.domain.Log;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.Map;

public class StringPredicateCreator extends PredicateCreator{

    public StringPredicateCreator(String key, Root<Log> log) {
        setKey(key);
        setLog(log);
    }

    @Override
    public Predicate createPredicate(Map<String, String> logDTO, CriteriaBuilder cb) throws ParseException {
        String rootKey =getRootKey(getKey());
        String value = logDTO.get(getKey());
        return value != null ? cb.equal(getLog().get(rootKey), value) : null;
    }
}
