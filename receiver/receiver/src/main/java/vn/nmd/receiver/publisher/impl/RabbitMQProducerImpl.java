package vn.nmd.receiver.publisher.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import vn.nmd.sender.entity.Job;
import vn.nmd.sender.publisher.IRabbitMQProducer;

@Service
@Slf4j
public class RabbitMQProducerImpl implements IRabbitMQProducer {

	@Value("${spring.rabbitmq.exchange.name}")
	private String exchangeName;

	@Value("${spring.rabbitmq.binding.routing-key}")
	private String routingKey;
	
	@Value("${spring.rabbitmq.binding.routing-json-queue-key}")
	private String routingJsonQueueKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void sendMessage(String message) {
		log.info(String.format("Message send -> %s", message));
		rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
	}
	
	@Override
	public void sendJsonMessage(Job jobData) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		log.info(String.format("Json send -> %s", objectMapper.writeValueAsString(jobData)));
		rabbitTemplate.convertAndSend(exchangeName,routingJsonQueueKey, jobData);
	}
}
