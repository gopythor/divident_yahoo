package com.example.divident_yh;

import com.example.divident_yh.model.Company;
import com.example.divident_yh.scraper.Scraper;
import com.example.divident_yh.scraper.YahooFinanceScraper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DividentYhApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(DividentYhApplication.class, args);
    }
}
