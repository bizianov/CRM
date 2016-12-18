package project.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.WeatherService;

/**
 * Created by slava23 on 12/18/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
public class WeatherController {

    @NonNull
    private WeatherService weatherService;

    @RequestMapping("/weather")
    public String getWeather(@RequestParam(name = "city") String city, Model model){
        String weather = weatherService.getWeather(city);
        model.addAttribute("weather", weather);
        return "weather/weather";
    }

}
