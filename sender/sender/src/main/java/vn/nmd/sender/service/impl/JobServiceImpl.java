package vn.nmd.sender.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public List<Job> getList() {
		return null;
	}
	
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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Job editJob(Job job) {
		return null;
	}

	@Override
	public Job getJob(Long id) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteJob(Long id) {
		
	}

}
