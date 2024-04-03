package com.turing.api.crawler;

import com.turing.api.common.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



@Repository
@RequiredArgsConstructor
public class CrawlerRepository extends AbstractRepository {


    private Map<String, ?> map;


    @Override
    public Map<String, ?> saveBugs(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10*1000).get();
        Elements elems = doc.select("table.byChart");
        Iterator<Element> bugsTitle = elems.select("p.title").iterator();
        Iterator<Element> bugsArtist = elems.select("p.artist").iterator();
        Iterator<Element> bugsRank = elems.select("strong").iterator();

        Map<String,Iterator<Element>> bugs = new HashMap<>();



        bugs.put("bugs.title",bugsTitle);
        bugs.put("bugs.artist",bugsArtist);
        bugs.put("bugs.rank",bugsRank);
        map = bugs;

        return map;
    }

    @Override
    public Map<String, ?> saveMelon(Map<String, String> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10*1000).get();
        Elements elems = doc.select("tbody");
        Iterator<Element> title = elems.select("div.ellipsis.rank01 > span").iterator();
        Iterator<Element> artist = elems.select("div.ellipsis.rank02 span").iterator();
        Iterator<Element> rank = elems.select("td span.rank").iterator();
        Map<String,Iterator<Element>> melon = new HashMap<>();

        melon.put("melon.title",title);
        melon.put("melon.artist",artist);
        melon.put("melon.rank",rank);
        map = melon;
        return map;
    }


}
