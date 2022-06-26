package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.utils.Utils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.util.*;

@Data
@Repository
public class LogDAO {
    @Autowired
    EntityManager em;

    public List<Log> findLogsV1(Map<String, String> logDTO, int page, int size) throws ParseException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Log> cq = cb.createQuery(Log.class);
        Root<Log> log = cq.from(Log.class);
        cq.select(log);

        List<Predicate> predicates = new ArrayList<>();
        Set<String> keys = logDTO.keySet();
        for (String key: keys) {
            Predicate pr = createPredicate(key);
            if (pr != null)
                predicates.add(pr);
        }

        cq.where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
        TypedQuery<Log> query = em.createQuery(cq);
        query.setFirstResult(page);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public List<Log> findLogsV2(Map<String, List<String>> logDTO, int page, int size) throws ParseException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Log> cq = cb.createQuery(Log.class);
        Root<Log> log = cq.from(Log.class);
        cq.select(log);

        List<Predicate> predicates = new ArrayList<>();

        //TODO Process for creation predicate according to JSON

        cq.where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
        TypedQuery<Log> query = em.createQuery(cq);
        query.setFirstResult(page);
        query.setMaxResults(size);
        return query.getResultList();
    }

    private Predicate createPredicate(String key) {

        //TODO Process for creation predicate according to JSON field

//        Object value = null;
//        String type = log.get(key).getJavaType().getName();
//            if (type.equals("Date")) {
//                value = Utils.parseDate(logDTO.get(key));
//                if (key.equals("startDate"))
//                    startDate = (Date) value;
//                else if (key.equals("endDate"))
//                    endDate = (Date) value;
//            } else if (type.equals("Integer")) {
//                value = Integer.valueOf(key);
//            } else {
//                value = key;
//            }
        // Predicate pr = cb.greaterThan(log.get(key).as(Date.class), (Date) value);
        // Predicate pr = cb.lessThan(log.get(key).as(Date.class), (Date) value);
        // Predicate between_date = cb.between(log.get("dateTime"), startDate, endDate);
        // Predicate pr = cb.equal(log.get(key), value);

        return null;
    }
}
