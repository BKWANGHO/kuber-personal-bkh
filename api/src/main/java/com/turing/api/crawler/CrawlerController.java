package com.turing.api.crawler;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor
@RestController
public class CrawlerController {

    private final CrawlerService service;

    public Map<String,?> findBugsMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오.");
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("URL",sc.next());
        return service.findNamesFromWebBugs(paramMap);
    }

    public Map<String,?> findMelonMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오.");
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("URL",sc.next());
        return service.findNamesFromWebMelon(paramMap);
    }
}
