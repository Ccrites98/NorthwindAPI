package com.pluralsight.NorthwindTradersAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String home(@RequestParam(name = "country", required = false) String country) {
        if (country != null && !country.isEmpty()) {
            return "Hello " + country;
        } else {
            return "Hello World";
        }
    }
}