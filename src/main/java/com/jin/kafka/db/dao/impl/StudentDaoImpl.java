package com.jin.kafka.db.dao.impl;

import com.jin.kafka.db.dao.DruidMarkInterface;
import com.jin.kafka.db.dao.StudentDao;
import com.jin.kafka.db.entity.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao, DruidMarkInterface {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void save(Student student) {
        hibernateTemplate.save(student);
    }
}
