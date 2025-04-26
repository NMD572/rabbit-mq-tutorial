package vn.nmd.sender.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.nmd.sender.entity.Job;

public interface IRabbitMQProducer {
	public void sendMessage(String message);
	
	public void sendJsonMessage(Job jobData) throws JsonProcessingException;
}
