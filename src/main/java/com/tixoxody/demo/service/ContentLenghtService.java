package com.tixoxody.demo.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

@Service
public class ContentLenghtService {
    public int getContentLenght(String html){
        int count = Jsoup.parse(html).body().text().replaceAll("\\s+","").length();
        return count;
    }
}
