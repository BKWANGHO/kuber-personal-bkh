package com.turing.api.crawler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class CrawlerServiceImpl implements CrawlerService{
    private final CrawlerRepository repository;



    @Override
    public Map<String, ?> findNamesFromWebMelon(Map<String, String> paramMap) throws IOException {
        return repository.saveMelon(paramMap);
    }

    @Override
    public Map<String,?> findNamesFromWebBugs(Map<String,String> paramMap) throws IOException {

        return repository.saveBugs(paramMap);

    }
}
