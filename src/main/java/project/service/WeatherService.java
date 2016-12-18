package project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * Created by slava23 on 12/18/2016.
 */

@Service
@Slf4j
public class WeatherService {

    @Value("${weather.website.base.url}")
    private String baseUrl;
    @Value("${weather.app.id}")
    private String appId;
    public static final String QUERY_FOR_CITY = "SELECT id FROM weather WHERE city = :city_param";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private RestTemplate restTemplate = new RestTemplate();

    public String getWeather(String city){
        StringBuilder builder = new StringBuilder(baseUrl)
                .append("?id=")
                .append(getCityId(city))
                .append("&appid=")
                .append(appId);
        String url = builder.toString();
        log.info("URL for RestTemplate is {}", url);
        return restTemplate.getForObject(url, String.class);
    }

    private int getCityId(String city){
        Map<String, String> namedParametersMap = Collections.singletonMap("city_param", city);
        return namedParameterJdbcTemplate.queryForObject(QUERY_FOR_CITY, namedParametersMap, Integer.class);
    }
}
