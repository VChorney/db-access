package com.db_access.dao;

import com.db_access.entity.Letter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LetterDaoImpl extends CrudRepository<Letter, Long> {

    List<Letter> findByRecipient(String recipient);
}