package com.example.springioctest.transaction.service;

import com.example.springioctest.transaction.model.TestDO;

public interface TestService {

    void save(TestDO test);

    void saveOne(TestDO test);
}
