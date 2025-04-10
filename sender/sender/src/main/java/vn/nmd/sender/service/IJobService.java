package vn.nmd.sender.service;

import java.util.List;

import vn.nmd.sender.entity.Job;

public interface IJobService {
	List<Job> getList();

	Job createJob(Job job);

	Job editJob(Job job);

	Job getJob(Long id);

	void deleteJob(Long id);
}
