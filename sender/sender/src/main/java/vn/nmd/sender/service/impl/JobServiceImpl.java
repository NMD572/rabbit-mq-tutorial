package vn.nmd.sender.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.nmd.sender.entity.Job;
import vn.nmd.sender.service.IJobService;

@Service
@Transactional(readOnly = true)
public class JobServiceImpl implements IJobService{

	
	
	@Override
	public List<Job> getList() {
		return null;
	}

	@Override
	public Job createJob(Job job) {
		return null;
	}

	@Override
	public Job editJob(Job job) {
		return null;
	}

	@Override
	public Job getJob(Long id) {
		return null;
	}

	@Override
	public void deleteJob(Long id) {
		
	}

}
