package project.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by slava23 on 10/19/2016.
 */

@Configuration
public class JavaConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/crm");
        dataSource.setUsername("root");
        dataSource.setPassword("moyagjhit911");
        return dataSource;
    }
}
