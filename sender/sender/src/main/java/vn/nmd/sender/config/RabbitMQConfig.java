package vn.nmd.sender.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.queue.name}")
	private String queueName;

	@Value("${spring.rabbitmq.queue.json-queue-name}")
	private String jsonQueueName;

	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${spring.rabbitmq.binding.routing-key}")
	private String routingKey;

	@Value("${spring.rabbitmq.binding.routing-json-queue-key}")
	private String routingJsonQueueKey;

	// spring bean for rabbitmq queue
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}

	// spring bean for rabbitmq queue (store json message)
	@Bean
	public Queue jsonQueue() {
		return new Queue(jsonQueueName);
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

	// binding between json queue and exchange using routing key
	@Bean
	public Binding bindingJsonQueue() {
		return BindingBuilder.bind(jsonQueue()).to(exchange()).with(routingJsonQueueKey);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}

	// Spring boot automatically config three bean for rabbitmq:
	// ConnectionFactory
	// RabbitTemplate
	// RabbitAdmin

}
