package com.example.logproject.repo;

import com.example.logproject.domain.Log;
import com.example.logproject.dto.LogDTO;
import com.example.logproject.utils.Utils;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class LogDAO {
    @Autowired
    LogRepository logRepository;

    public List<Log> findLogsV1(Map<String, String> logDTO, int page, int size) throws ParseException {

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Log> cq = cb.createQuery(Log.class);
//        Root<Log> log = cq.from(Log.class);
//        cq.select(log);
//
//        List<Predicate> predicates = new ArrayList<>();
//        Set<String> keys = logDTO.keySet();
//        for (String key: keys) {
//            PredicateCreator creator = PredicateCreatorFactory.getCreator(key, log);
//            Predicate pr = creator.createPredicate(logDTO, cb);
//            if (pr != null)
//                predicates.add(pr);
//        }
//
//        cq.where(predicates.toArray(new Predicate[predicates.size()]));
//        TypedQuery<Log> query = em.createQuery(cq);
//        query.setFirstResult(page);
//        query.setMaxResults(size);
//        return query.getResultList();
        return null;
    }

    public List<Log> findLogsV2(Map<String, List<String>> logDTO, int page, int size) throws ParseException {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Log> cq = cb.createQuery(Log.class);
//        Root<Log> log = cq.from(Log.class);
//        cq.select(log);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        //TODO Process for creation predicate according to JSON
//
//        cq.where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
//        TypedQuery<Log> query = em.createQuery(cq);
//        query.setFirstResult(page);
//        query.setMaxResults(size);
//        return query.getResultList();
        return null;
    }
}
