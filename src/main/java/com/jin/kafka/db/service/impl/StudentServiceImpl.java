package com.jin.kafka.db.service.impl;

import com.jin.kafka.db.dao.StudentDao;
import com.jin.kafka.db.entity.Student;
import com.jin.kafka.db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }
}
