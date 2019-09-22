package com.kafka.demo.controller;

import com.kafka.demo.service.LogConsumerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;


/**
 * Controller class which show index.html
 */
@Controller
public class CityLogController {

    private LogConsumerService logConsumerService;

    public CityLogController(LogConsumerService logConsumerService) {

        this.logConsumerService = logConsumerService;
    }

    /**
     * @param map Send ModelMap data to html page
     */
    @RequestMapping("/logs")
    public String monitorCitiesLogs(ModelMap map) {
        HashMap<String, Integer> cityLogCounts = logConsumerService.runLogConsumerService();
        int istLogCount = cityLogCounts.get("Istanbul");
        int tokyoLogCount = cityLogCounts.get("Tokyo");
        int beijingLogCount = cityLogCounts.get("Beijing");
        int moskowLogCount = cityLogCounts.get("Moskow");
        int londonLogCount = cityLogCounts.get("London");
        map.addAttribute("istanbul", istLogCount);
        map.addAttribute("tokyo", tokyoLogCount);
        map.addAttribute("beijing", beijingLogCount);
        map.addAttribute("moskow", moskowLogCount);
        map.addAttribute("london", londonLogCount);
        return "index.html";
    }


}
