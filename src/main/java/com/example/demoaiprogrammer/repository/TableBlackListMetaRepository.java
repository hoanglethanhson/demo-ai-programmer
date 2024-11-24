package com.example.demoaiprogrammer.repository;

import com.example.demoaiprogrammer.entity.TableBlackListMeta;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@CacheConfig(cacheManager = "caffeineCacheManager", cacheNames = "blackListMeta")
public interface TableBlackListMetaRepository extends JpaRepository<TableBlackListMeta, Integer> {
    @Cacheable(value = "blackListMeta")
    Optional<TableBlackListMeta> findFirstByStatusOrderByBlackListCodeAsc(int status);

    @CacheEvict(value = "blackListMeta", key = "#id")
    void deleteById(int id);

    @CacheEvict(value = "blackListMeta", allEntries = true)
    void deleteAll();
}
