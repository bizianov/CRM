package weather;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.WeatherController;
import project.service.weather.CurrentWeatherService;
import project.service.weather.ForecastWeatherService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 12/23/2016.
 */
public class WeatherViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void currentWeather() throws Exception {
        mockMvc.perform(get("/currentWeather?city=Kiev"))
                .andExpect(view().name("weather/currentWeather"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        CurrentWeatherService currentWeatherService = mock(CurrentWeatherService.class);
        ForecastWeatherService forecastWeatherService = mock(ForecastWeatherService.class);
        WeatherController weatherController = WeatherController.of(currentWeatherService, forecastWeatherService);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
