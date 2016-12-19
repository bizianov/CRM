package project.service.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
public class CurrentWeatherService {

    @Value("${weather.website.base.url}")
    private String baseUrl;
    @Value("${weather.app.id}")
    private String appId;
    public static final String QUERY_FOR_CITY = "SELECT id FROM weather WHERE city = :city_param";
    public static final Double KELVIN = 273.0;


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> getWeather(String city) throws IOException {
        Integer cityId = getCityId(city);
        if (cityId == null){
            return Collections.emptyMap();
        }
        StringBuilder builder = new StringBuilder(baseUrl)
                .append("?id=")
                .append(cityId)
                .append("&appid=")
                .append(appId);
        String url = builder.toString();
        log.info("URL for RestTemplate is {}", url);
        String rawWeather = restTemplate.getForObject(url, String.class);
        return parseRawValues(rawWeather);
    }

    private Integer getCityId(String city){
        Map<String, String> namedParametersMap = Collections.singletonMap("city_param", city);
        try {
            Integer cityId = namedParameterJdbcTemplate.queryForObject(QUERY_FOR_CITY, namedParametersMap, Integer.class);
            return cityId;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
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
