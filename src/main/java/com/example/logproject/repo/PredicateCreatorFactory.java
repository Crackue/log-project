package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import com.example.logproject.utils.Utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.Date;

public class PredicateCreatorFactory {

    public static PredicateCreator getCreator(String key, Root<Log> log) {

        String root_key = Utils.getRootKey(key);

        Class clazz = log.get(root_key).getJavaType();
        if (clazz.equals(Date.class)) {
            return new DatePredicateCreator(key, log);
        } else if (clazz.equals(Integer.class)) {
            return new NumberPredicateCreator(key, log);
        } else {
            return new StringPredicateCreator(key, log);
        }
    }
}
