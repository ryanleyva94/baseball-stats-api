package leyva.ryan.baseballstatsapi.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class BaseballStatsListenerImplementation implements BaseballStatsListener
{
    @Override
    @RabbitListener(queues = "${spring.rabbitmq.queues.baseball-player}", containerFactory = "rabbitListenerContainerFactory")
    public void receiveMessage(Message message)
    {
        System.out.println(message);
    }
}
