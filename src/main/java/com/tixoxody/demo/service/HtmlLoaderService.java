package com.tixoxody.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HtmlLoaderService {
    public Document loadPage(String urlPage) throws IOException {
       return Jsoup.connect(urlPage).get();
    }
}
