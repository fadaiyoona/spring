package com.example.springioctest.transaction.service.impl;

import com.example.springioctest.transaction.dao.TestDao;
import com.example.springioctest.transaction.model.TestDO;
import com.example.springioctest.transaction.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Autowired
    private TestService testService;

    @Transactional
    @Override
    public void save(TestDO test) {
        try {
            testDao.save(test);

            testService.saveOne(test);

            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("hello un effective throw");
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void saveOne(TestDO test) {
        testDao.save(test);

        throw new RuntimeException();
    }


}
