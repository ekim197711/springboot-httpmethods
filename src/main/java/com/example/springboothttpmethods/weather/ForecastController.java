package com.example.springboothttpmethods.weather;

import lombok.experimental.ExtensionMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/forecast")
@ExtensionMethod({java.time.LocalDateTime.class, MyTimeExtensions.class})
public class ForecastController {

    @GetMapping("/today")
    public String today() {
        return "sunny " + LocalDateTime.now().toDanishFormat("The portatoes are growing too fast.");
    }

    @GetMapping(value = "/tomorrow")
    public String tomorrow() {
        return "cloudy";
    }

}
