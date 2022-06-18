package leyva.ryan.baseballstatsapi.config;

import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao;
import leyva.ryan.baseballstatsapi.daos.BaseballStatsMySQL;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListener;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListenerImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig
{
    @Bean
    BaseballStatsListener baseballStatsListener()
    {
        return new BaseballStatsListenerImplementation();
    }

    @Bean
    BaseballStatsDao baseballStatsDao(JdbcTemplate jdbcTemplate)
    {
        return new BaseballStatsMySQL(jdbcTemplate);
    }
}
