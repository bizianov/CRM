package project.service.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by slava23 on 12/18/2016.
 */

@Service
@Slf4j
public class CurrentWeatherService extends WeatherService{

    @Value("${weather.current.url}")
    private String currentUrl;

    public Map<String, Double> getWeather(String city) throws IOException {
        String url = buildUrl(currentUrl, city);
        log.info("URL for RestTemplate is {}", url);
        if (url.isEmpty()){
            return Collections.emptyMap();
        }
        String rawWeather = restTemplate.getForObject(url, String.class);
        return parseRawValues(rawWeather);
    }

    private Map<String, Double> parseRawValues(String rawValues) throws IOException {
        Map<String, Double> weatherValues = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(rawValues);
        JsonNode mainNode = jsonNode.get("main");

        JsonNode temperature = mainNode.path("temp");
        JsonNode humidity = mainNode.path("humidity");
        weatherValues.put("temperature",
                Double.valueOf(new DecimalFormat("##.#")
                        .format(temperature.doubleValue() - KELVIN)));
        weatherValues.put("humidity", humidity.doubleValue());

        return weatherValues;
    }
}
