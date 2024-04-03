package com.turing.api.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String,?> findNamesFromWebBugs(Map<String,String> paramMap) throws IOException;

    Map<String,?> findNamesFromWebMelon(Map<String, String> paramMap) throws IOException;

}
