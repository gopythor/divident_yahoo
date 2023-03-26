package com.example.divident_yh.scraper;

import com.example.divident_yh.model.Company;
import com.example.divident_yh.model.ScrapedResult;

public interface Scraper {
    Company scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(Company company);
}