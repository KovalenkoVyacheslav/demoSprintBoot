package com.tixoxody.demo.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.jsoup.select.Elements;

@Service
public class ParagraphService {

    public int getCountParagraph(String html){
        Elements el = Jsoup.parse(html).body().select("p");
        return el.size();
    }
}

