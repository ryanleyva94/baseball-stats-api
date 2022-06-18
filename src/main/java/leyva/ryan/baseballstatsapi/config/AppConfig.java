package leyva.ryan.baseballstatsapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao;
import leyva.ryan.baseballstatsapi.daos.BaseballStatsMySQL;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListener;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListenerImplementation;
import leyva.ryan.baseballstatsapi.services.GameAddingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig
{
    @Bean
    BaseballStatsListener baseballStatsListener(ObjectMapper objectMapper, GameAddingService gameAddingService)
    {
        return new BaseballStatsListenerImplementation(objectMapper, gameAddingService);
    }

    @Bean
    GameAddingService gameAddingService(BaseballStatsDao baseballStatsDao)
    {
        return new GameAddingService(baseballStatsDao);
    }

    @Bean
    BaseballStatsDao baseballStatsDao(JdbcTemplate jdbcTemplate)
    {
        return new BaseballStatsMySQL(jdbcTemplate);
    }
}
