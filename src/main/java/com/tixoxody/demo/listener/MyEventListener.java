package com.tixoxody.demo.listener;

import com.tixoxody.demo.service.HtmlLoaderService;
import com.tixoxody.demo.service.MetaTagService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@Component
public class MyEventListener {
    @Autowired // ініціалізування сервіса об'єкту
    private HtmlLoaderService htmlLoaderService;

    @Autowired
    private MetaTagService metaTagService;

    @EventListener(ApplicationReadyEvent.class)
    public void ApplicationStart(){
        System.out.println("Start");
        String url = "https://habr.com/";
        try {
            Document htmlDocument = htmlLoaderService.loadPage(url);
            String html = htmlDocument.html();
            //System.out.println(html);

            System.out.println("Title: ");
            System.out.println(metaTagService.getTitle(htmlDocument));

            System.out.println("Content: ");
            System.out.println(metaTagService.getDescription(htmlDocument));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
