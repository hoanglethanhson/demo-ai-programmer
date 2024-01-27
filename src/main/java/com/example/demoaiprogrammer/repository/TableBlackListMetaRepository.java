package com.example.demoaiprogrammer.repository;

import com.example.demoaiprogrammer.entity.TableBlackListMeta;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableBlackListMetaRepository extends JpaRepository<TableBlackListMeta, Integer> {
    @Cacheable(value = "blackListMeta")
    Optional<TableBlackListMeta> findFirstByStatusOrderByBlackListCodeAsc(int status);

}
