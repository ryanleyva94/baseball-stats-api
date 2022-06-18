package leyva.ryan.baseballstatsapi;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.sql.DataSource;

@SpringBootTest
class BaseballStatsApiApplicationTests {

	@MockBean
	private DataSource dataSource;

	@MockBean
	private ConnectionFactory connectionFactory;

	@MockBean
	private AmqpAdmin amqpAdmin;

	@Test
	void contextLoads() {
	}

}
