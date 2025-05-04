package vn.nmd.reporter.consumer.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vn.nmd.receiver.entity.Job;
import vn.nmd.reporter.consumer.IRabbitMQConsumer;

@Service
@Slf4j
public class RabbitMQConsumerImpl implements IRabbitMQConsumer {

	
	@Override
	@RabbitListener(queues = { "${spring.rabbitmq.queue.name}" })
	public void consumeNmdFirstQueue(String data) {
		// consumer raw string message
		log.info(String.format("Message receive -> %s", data));
	}
	
	@Override
	@RabbitListener(queues = { "${spring.rabbitmq.queue.json-queue-name}" })
	public void consumeNmdJsonRoutingKey(Job job) {
		// consumer raw string message
		log.info(String.format("Message receive -> %s", job.getId()));
	}
	

}
