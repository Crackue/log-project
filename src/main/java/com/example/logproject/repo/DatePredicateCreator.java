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
import java.util.Date;
import java.util.Map;

@NoArgsConstructor
public class DatePredicateCreator extends PredicateCreator {

    public DatePredicateCreator(String key, Root<Log> log) {
        setKey(key);
        setLog(log);
    }

    @Override
    public Predicate createPredicate(Map<String, String> logDTO, CriteriaBuilder cb) throws ParseException {
        String rootKey = getRootKey(getKey());
        Date date = Utils.parseDate(logDTO.get(getKey()));
        if (getKey().startsWith("start")) {
            Predicate pr = cb.greaterThanOrEqualTo(getLog().get(rootKey).as(Date.class), date);
            return pr;
        }
        else if (getKey().startsWith("end")) {
            Predicate pr = cb.lessThanOrEqualTo(getLog().get(rootKey).as(Date.class), date);
            return pr;
        }
        return null;
    }
}
