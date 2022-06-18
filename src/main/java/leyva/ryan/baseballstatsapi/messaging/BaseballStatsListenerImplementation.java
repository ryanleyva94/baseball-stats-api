package leyva.ryan.baseballstatsapi.messaging;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import leyva.ryan.baseballstatsapi.model.Game;
import leyva.ryan.baseballstatsapi.services.GameAddingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

public class BaseballStatsListenerImplementation implements BaseballStatsListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseballStatsListenerImplementation.class);

    private final ObjectMapper objectMapper;
    private final GameAddingService gameAddingService;

    public BaseballStatsListenerImplementation(ObjectMapper objectMapper, GameAddingService gameAddingService)
    {
        this.objectMapper = objectMapper;
        this.gameAddingService = gameAddingService;
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.baseball-player}", containerFactory = "rabbitListenerContainerFactory")
    public void receiveMessage(Message message)
    {
        try
        {
            gameAddingService.addGameStats(objectMapper.readValue(message.getBody(), Game.class));
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage());
            //TODO send notification to admin upon error
        }
    }
}
