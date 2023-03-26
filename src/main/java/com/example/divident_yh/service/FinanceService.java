package com.example.divident_yh.service;

import com.example.divident_yh.exception.impl.NoCompanyException;
import com.example.divident_yh.model.Company;
import com.example.divident_yh.model.Dividend;
import com.example.divident_yh.model.ScrapedResult;
import com.example.divident_yh.model.constants.CacheKey;
import com.example.divident_yh.persist.CompanyRepository;
import com.example.divident_yh.persist.DividendRepository;
import com.example.divident_yh.persist.entity.CompanyEntity;
import com.example.divident_yh.persist.entity.DividendEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@Service
@AllArgsConstructor
public class FinanceService {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    // 요청이 자주 들어오는가??
    // 자주 변경되는 데이터 인가??

    @Cacheable(key ="#companyName", value = CacheKey.KEY_FINANCE)
    public ScrapedResult getDividendByCompanyName(String companyName) {

        log.info("search company ->" + companyName);

        //1. Search company information by company name
        CompanyEntity company = this.companyRepository.findByName(companyName)
                .orElseThrow(() -> new NoCompanyException());


        //2. Query dividend information with the queried company ID
        List<DividendEntity> dividendEntities = this.dividendRepository.findAllByCompanyId(company.getId());

        //3. return after combination of results
        List<Dividend> dividends = dividendEntities.stream()
                         .map(e -> new Dividend(e.getDate(), e.getDividend()))
                         .collect(Collectors.toList());
        return new ScrapedResult(new Company(company.getTicker(), company.getName()), dividends);
    }
}