package leyva.ryan.baseballstatsapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import leyva.ryan.baseballstatsapi.daos.BaseballStatsDao;
import leyva.ryan.baseballstatsapi.daos.BaseballStatsMySQL;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListener;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListenerImplementation;
import leyva.ryan.baseballstatsapi.services.GameAddingService;
import leyva.ryan.baseballstatsapi.services.GameReadingService;
import leyva.ryan.baseballstatsapi.services.StatCalculatingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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
    GameReadingService gameReadingService(BaseballStatsDao baseballStatsDao, StatCalculatingService statCalculatingService)
    {
        return new GameReadingService(baseballStatsDao, statCalculatingService);
    }

    @Bean
    StatCalculatingService statCalculatingService()
    {
        return new StatCalculatingService();
    }

    @Bean
    BaseballStatsDao baseballStatsDao(JdbcTemplate jdbcTemplate)
    {
        return new BaseballStatsMySQL(jdbcTemplate);
    }
}
