package com.example.springioctest.transaction.dao;

import com.example.springioctest.transaction.model.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
    @Autowired
    private JdbcTemplate namedParameterJdbcTemplate;

    public int save(TestDO entity) {
        String sql = "insert into test(name) values(?)";
        return namedParameterJdbcTemplate.update(sql, entity.getName());
    }

}
