package project.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.weather.CurrentWeatherService;
import project.service.weather.WeatherForecastService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/18/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
public class WeatherController {

    @NonNull
    private CurrentWeatherService currentWeatherService;
    @NonNull
    private WeatherForecastService weatherForecastService;

    @RequestMapping("/currentWeather")
    public String getWeather(@RequestParam(name = "city") String city, Model model){
        try {
            Map<String, Double> weatherValues = currentWeatherService.getWeather(city);
            model.addAttribute("city", city);
            if (weatherValues.isEmpty() || weatherValues == null){
                return "weather/error";
            }
            model.addAttribute("weatherValues", weatherValues);
            return "weather/currentWeather";
        } catch (IOException e){
            model.addAttribute("city", city);
            return "weather/error";
        }
    }

    @RequestMapping("/weatherForecast")
    public String getWeatherForecast(@RequestParam(name = "city") String city, Model model){
        try {
            List<List<String>> weatherForecast = weatherForecastService.getWeatherForecast(city);
            model.addAttribute("city", city);
            model.addAttribute("forecast",weatherForecast);
            return "weather/weatherForecast";
        } catch (IOException e) {
            model.addAttribute("city", city);
            return "weather/error";
        }
    }

    @RequestMapping(value = "/weather", method = GET)
    public String weatherMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "weather/weather";
    }

}
