package com.example.demoaiprogrammer.service.impl;

import com.example.demoaiprogrammer.entity.MsisdnBlackList;
import com.example.demoaiprogrammer.entity.TableBlackListMeta;
import com.example.demoaiprogrammer.repository.MsisdnBlackListRepository;
import com.example.demoaiprogrammer.repository.TableBlackListMetaRepository;
import com.example.demoaiprogrammer.service.MsisdnBlackListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MsisdnBlackListServiceImpl implements MsisdnBlackListService {
    private final TableBlackListMetaRepository tableBlackListMetaRepository;
    private final MsisdnBlackListRepository msisdnBlackListRepository;

    public MsisdnBlackListServiceImpl(TableBlackListMetaRepository tableBlackListMetaRepository, MsisdnBlackListRepository msisdnBlackListRepository) {
        this.tableBlackListMetaRepository = tableBlackListMetaRepository;
        this.msisdnBlackListRepository = msisdnBlackListRepository;
    }

    public String getActiveBlackListTableName() {
        Optional<TableBlackListMeta> blackListMetaOptional = tableBlackListMetaRepository.findFirstByStatusOrderByBlackListCodeAsc(1);
        //TODO: throw exception if not found
        tableBlackListMetaRepository.deleteById(blackListMetaOptional.get().getId());
        return blackListMetaOptional.map(TableBlackListMeta::getTableName).orElse(null);
    }

    @Override
    public boolean isInMsisdnBlackList(String msisdn) {
        String activeBlackListTableName = getActiveBlackListTableName();
        log.info("activeBlackListTableName: {}", activeBlackListTableName);
        Optional<MsisdnBlackList> optionalResult = msisdnBlackListRepository.findByMsisdn(msisdn, activeBlackListTableName);
        if (optionalResult.isEmpty()) {
            log.error("result not found");
        }
        return optionalResult.isPresent();
    }

    public void newFeature() {
        //new feature impl here =))
    }
}
