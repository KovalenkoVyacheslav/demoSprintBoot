package com.tixoxody.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {
    public static final String[] headers = {"h1", "h2", "h3", "h4", "h5", "h6"};

    public int getH(String html){
        int counter = 0;
        for (int i = 0; i < headers.length; i++) {
            Elements el = Jsoup.parse(html).body().select(headers[i]);
            counter += el.size();
        }
        return counter;
    }
}
