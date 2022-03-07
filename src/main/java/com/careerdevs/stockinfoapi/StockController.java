package com.careerdevs.stockinfoapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StockController {
    private String myAlphaVantageKey = "7C2UJO3FXLL3GZB5";

    @GetMapping("/{symbol}")
    public Object symbolHandler (RestTemplate restTemplate, @PathVariable("symbol") String symbol) {
        Object requestData = restTemplate.getForObject("https://www.alphavantage.co/query?function=OVERVIEW&symbol="+symbol+"&apikey=" + myAlphaVantageKey, Object.class);
        return requestData;
    }

    @GetMapping("/list")
    public Object rootHandler (RestTemplate restTemplate) {
        Object requestData = restTemplate.getForObject("https://www.alphavantage.co/query?function=LISTING_STATUS&apikey="+myAlphaVantageKey, String.class);
        return requestData;
    }
    @GetMapping("/")
    private static String rootRoute(){
        return "Welcome to Stock Info API";
    }
}
