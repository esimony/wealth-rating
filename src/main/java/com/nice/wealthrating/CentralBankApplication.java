package com.nice.wealthrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CentralBankApplication {

    @GetMapping(" central-bank/regional-info/evaluate")
    public Integer getEvaluation(@RequestParam(value = "city", defaultValue = "") String city) {
        Integer asset = 0;
        switch (city) {
            case "Tel Aviv":
                asset = 20000;
                break;
            case "Jerusalem":
                asset = 25000;
                break;
            case "New-York":
                asset = 50000;
                break;
            case "Paris":
                asset = 40000;
                break;
            case "Washington":
                asset = 30000;
                break;
        }

        return asset;
    }

    @GetMapping(" central-bank/wealth-threshold")
    public Integer getThreshold() {
        return 10000000;
    }

}