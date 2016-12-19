package project.service.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by slava23 on 12/19/2016.
 */
@Service
@Slf4j
public class WeatherForecastService extends WeatherService {

    @Value("${weather.forecast.url}")
    private String forecastUrl;

   public List<List<String>> getWeatherForecast(String city) throws IOException {
       String url = buildUrl(forecastUrl, city);
       log.info("URL for RestTemplate is {}", url);
       String rawWeatherForecast = restTemplate.getForObject(url, String.class);
       return parseRawWeatherForecast(rawWeatherForecast);
   }

   private List<List<String>> parseRawWeatherForecast(String rawValues) throws IOException {
       List<List<String>> weatherForecast = new ArrayList<>();

       ObjectMapper objectMapper = new ObjectMapper();
       JsonNode jsonNode = objectMapper.readTree(rawValues);
       JsonNode lastNode = jsonNode;
       Iterator<JsonNode> iterator = jsonNode.iterator();
       while(iterator.hasNext()){
           JsonNode currentNode = iterator.next();
           lastNode = currentNode;
       }

       Iterator<JsonNode> elements = lastNode.elements();
       while (elements.hasNext()){
           JsonNode next = elements.next();
           String date = String.valueOf(next.get("dt_txt"));
           double temperature = next.get("main").path("temp").doubleValue();
           List<String> currentList = new ArrayList<>();
           currentList.add(date);
           currentList.add(String.valueOf(Double.valueOf(new DecimalFormat("##.#").format(temperature - KELVIN))));
           if (currentList.get(0).contains("12:00") || currentList.get(0).contains("18:00")) {
               weatherForecast.add(currentList);
           }
       }

       return weatherForecast;
   }


}
