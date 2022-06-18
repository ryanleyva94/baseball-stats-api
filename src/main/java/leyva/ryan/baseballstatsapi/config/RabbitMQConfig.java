package leyva.ryan.baseballstatsapi.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig
{
    @Bean
    Queue playerQueue(@Value("${spring.rabbitmq.queues.baseball-player}") String queueName)
    {
        return new Queue(queueName, true);
    }

    @Bean
    Exchange statsExchange(@Value("${spring.rabbitmq.exchanges.baseball}") String exchangeName)
    {
        return new TopicExchange(exchangeName, true, false);
    }

    @Bean
    Binding queueBinding(Queue playerQueue, Exchange statsExchange, @Value("${spring.rabbitmq.bindings.baseball-player-stats}") String bindingName)
    {
        return BindingBuilder
                .bind(playerQueue)
                .to(statsExchange)
                .with(bindingName)
                .noargs();
    }

    @Bean
    AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory, Queue playerQueue, Exchange statsExchange, Binding queueBinding)
    {
        AmqpAdmin amqpAdmin = new RabbitAdmin(connectionFactory);
        amqpAdmin.declareExchange(statsExchange);
        amqpAdmin.declareQueue(playerQueue);
        amqpAdmin.declareBinding(queueBinding);

        return amqpAdmin;
    }

    @Bean
    ConnectionFactory connectionFactory(RabbitProperties rabbitProperties)
    {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(rabbitProperties.getHost());
        connectionFactory.setPort(rabbitProperties.getPort());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());

        return connectionFactory;
    }

    @Bean
    RabbitListenerContainerFactory<SimpleMessageListenerContainer> rabbitListenerContainerFactory(ConnectionFactory connectionFactory)
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        return factory;
    }

}
