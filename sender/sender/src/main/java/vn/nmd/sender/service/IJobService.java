package vn.nmd.sender.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.nmd.sender.entity.Job;

public interface IJobService {
	List<Job> getList();

	Job createJob(Job job) throws JsonProcessingException;

	Job editJob(Job job);

	Job getJob(Long id);

	void deleteJob(Long id);

	void sendMessage(String message);
}
