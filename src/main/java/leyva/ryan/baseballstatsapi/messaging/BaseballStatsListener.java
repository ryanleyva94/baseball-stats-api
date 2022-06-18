package leyva.ryan.baseballstatsapi.messaging;

import org.springframework.amqp.core.Message;

public interface BaseballStatsListener
{
    void receiveMessage(Message message);
}
