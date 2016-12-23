package project.service.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * Created by slava23 on 12/19/2016.
 */

@Service
public class WeatherService {

    public static final Double KELVIN = 273.0;
    public static final String QUERY_FOR_CITY = "SELECT id FROM weather WHERE city = :city_param";

    @Value("${weather.website.base.url}")
    String baseUrl;
    @Value("${weather.app.id}")
    String appId;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    RestTemplate restTemplate = new RestTemplate();

    Integer getCityId(String city){
        Map<String, String> namedParametersMap = Collections.singletonMap("city_param", city);
        try {
            Integer cityId = namedParameterJdbcTemplate.queryForObject(QUERY_FOR_CITY, namedParametersMap, Integer.class);
            return cityId;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    String buildUrl(String weatherUrl, String city){
        Integer cityId = getCityId(city);
        if (cityId == null){
            return "";
        }
        StringBuilder builder = new StringBuilder(baseUrl)
                .append(weatherUrl)
                .append("?id=")
                .append(cityId)
                .append("&appid=")
                .append(appId);
        return builder.toString();
    }

}
