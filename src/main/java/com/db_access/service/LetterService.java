package com.db_access.service;

import com.db_access.dao.LetterDaoImpl;
import com.db_access.entity.Letter;
import com.db_access.exceptions.NoLetterWithThatId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LetterService {


    ValidationService validationService;
    LetterDaoImpl letterDao;

    public Letter findById(Long id) {
        return letterDao.findById(id).orElseThrow(() ->
                new NoLetterWithThatId("There is no letter with that id =" + id)
        );
    }

    public List<Letter> findByRecipient(String recipient) {
        return letterDao.findByRecipient(recipient);
    }

    public List<Letter> getAll() {
        return StreamSupport.stream(letterDao.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void save(Letter letter) {
        validationService.validate(letter);
        letterDao.save(letter);
    }

    public void update(Letter letter) {
        letterDao.save(letter);
    }


    public void deleteById(Long id) {
        letterDao.deleteById(id);
    }
}
