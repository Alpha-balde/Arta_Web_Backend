package com.ibmap.dental.application.services;

import com.ibmap.dental.application.exception.custom.EntityNotFoundException;
import com.ibmap.dental.domaine.BasicEntity;
import com.ibmap.dental.domaine.entities.Meeting;
import com.ibmap.dental.repositories.CommonsRepository;

import java.util.List;

public interface CommonsService<T extends BasicEntity> {

    default T save(T entity) {
        return (T) getRepo().save(entity);
    }
    default T findByBusinessKey(String businessKey)  {
        try {
            return (T) getRepo().findByBusinessKey(businessKey)
                    .orElseThrow(() -> new Exception("no results found for the business key ["+businessKey+"]"));
        } catch (Throwable e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
    default List<T> findAll() {
        return getRepo().findAll();
    }
    default void deleteByBusinessKey(String businessKey) {
        Meeting meeting = (Meeting) findByBusinessKey(businessKey);
        delete((T) meeting);
    }
    default void delete(T entity) {
        getRepo().delete(entity);
    }

    CommonsRepository getRepo();
}
