package com.example.demoaiprogrammer.repository.impl;

import com.example.demoaiprogrammer.entity.MsisdnBlackList;
import com.example.demoaiprogrammer.repository.MsisdnBlackListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class MsisdnBlackListRepositoryImpl implements MsisdnBlackListRepository{
    private final JdbcTemplate jdbcTemplate;

    public MsisdnBlackListRepositoryImpl(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Cacheable(value = "msisdnBlackList", key = "#msisdn")
    public Optional<MsisdnBlackList> findByMsisdn(String msisdn, String tableName) {
        String query = "SELECT * FROM " + tableName + " WHERE msisdn = ?";
        try {
            MsisdnBlackList result = jdbcTemplate.queryForObject(query, new Object[]{msisdn}, (rs, rowNum) -> MsisdnBlackList.builder()
                    .msisdn(rs.getString("msisdn"))
                    .build());
            return Optional.ofNullable(result);
        } catch (EmptyResultDataAccessException exception) {
            log.info("{} not found in bl table {}", msisdn, tableName);
            return Optional.empty();
        }

    }
}
