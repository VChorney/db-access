package com.db_access.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {

    Optional<T> findById(Long id);

    List<T> findByRecipient(String recipient);

    List<T> findAll();

    void save(T t);

    void updateById(T t);

    void deleteById(Long id);

}