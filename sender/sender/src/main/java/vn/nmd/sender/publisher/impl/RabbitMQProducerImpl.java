package vn.nmd.sender.publisher.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vn.nmd.sender.publisher.IRabbitMQProducer;

@Service
@Slf4j
public class RabbitMQProducerImpl implements IRabbitMQProducer {

	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${spring.rabbitmq.binding.routing-key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void sendMessage(String message) {
		log.info(String.format("Message send -> %s", message));
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}
}
