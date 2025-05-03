package vn.nmd.sender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.nmd.sender.entity.Job;
import vn.nmd.sender.publisher.IRabbitMQProducer;
import vn.nmd.sender.repository.JobRepository;
import vn.nmd.sender.service.IJobService;

@Service
@Transactional(readOnly = true)
public class JobServiceImpl implements IJobService{

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private IRabbitMQProducer rabbitMQProducer;

	
	@Override
	public void sendMessage(String message) {
		rabbitMQProducer.sendMessage(message);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Job createJob(Job job) throws JsonProcessingException {
		jobRepository.save(job);
		rabbitMQProducer.sendJsonMessage(job);
		return job;
	}


}
