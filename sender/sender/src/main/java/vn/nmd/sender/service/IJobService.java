package vn.nmd.sender.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.nmd.sender.entity.Job;

public interface IJobService {

	Job createJob(Job job) throws JsonProcessingException;

	void sendMessage(String message);
}
