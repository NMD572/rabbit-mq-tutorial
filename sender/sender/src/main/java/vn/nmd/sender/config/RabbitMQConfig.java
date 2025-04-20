package vn.nmd.sender.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.queue.name}")
	private String queueName;

	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${spring.rabbitmq.binding.routing-key}")
	private String routingKey;

	// spring bean for rabbitmq queue
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}

	// spring bean for rabbitmq exchange
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchangeName);
	}

	// binding between queue and exchange using routing key
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
	}
	
	// Spring boot automatically config three bean for rabbitmq:
	// ConnectionFactory
	// RabbitTemplate
	// RabbitAdmin

}
