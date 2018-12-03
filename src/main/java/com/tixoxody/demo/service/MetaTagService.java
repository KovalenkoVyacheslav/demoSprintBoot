package com.tixoxody.demo.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class MetaTagService {

    public String getTitle(Document doc){
        return doc.title();
    }

    public String getDescription(Document doc) {
        Elements el = doc.select("meta");
        for (Element local: el) {
            if(local.hasAttr("name") && local.attr("name").equals("description")){
                return local.attr("content");
            }
        }
        return "";
    }
}
