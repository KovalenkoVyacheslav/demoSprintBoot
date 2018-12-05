package com.tixoxody.demo.listener;

import com.tixoxody.demo.service.*;
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

    @Autowired
    private ParagraphService paragraphService;

    @Autowired
    private HeaderService headerService;

    @Autowired
    private ContentLenghtService contentLenghtService;

    @EventListener(ApplicationReadyEvent.class)
    public void ApplicationStart(){
        System.out.println("Start");
        String url = "https://habr.com/";
        try {
            Document htmlDocument = htmlLoaderService.loadPage(url);
            String html = htmlDocument.html();
            //System.out.println(html);

            System.out.println("Title: " + metaTagService.getTitle(htmlDocument));

            System.out.println("Content: " + metaTagService.getDescription(htmlDocument));

            System.out.println("Paragraph count = " + paragraphService.getCountParagraph(html));

            System.out.println("Headers = " + headerService.getH(html));

            System.out.println("Content lenght = " + contentLenghtService.getContentLenght(html));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
