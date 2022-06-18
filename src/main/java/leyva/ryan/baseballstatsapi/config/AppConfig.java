package leyva.ryan.baseballstatsapi.config;

import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListener;
import leyva.ryan.baseballstatsapi.messaging.BaseballStatsListenerImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    BaseballStatsListener baseballStatsListener()
    {
        return new BaseballStatsListenerImplementation();
    }
}
