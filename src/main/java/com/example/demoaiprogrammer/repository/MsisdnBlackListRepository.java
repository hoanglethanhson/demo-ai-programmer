package com.example.demoaiprogrammer.repository;

import com.example.demoaiprogrammer.entity.MsisdnBlackList;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface MsisdnBlackListRepository {
    Optional<MsisdnBlackList> findByMsisdn(String msisdn, String tableName);
}
