package vn.nmd.sender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.nmd.sender.entity.Job;
import vn.nmd.sender.service.IJobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private IJobService jobService;

	@GetMapping
	public ResponseEntity<List<Job>> getList() {
		try {
			return new ResponseEntity<>(jobService.getList(), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		try {
			return new ResponseEntity<>(jobService.createJob(job), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping
	public ResponseEntity<Job> editJob(@RequestBody Job job) {
		try {
			return new ResponseEntity<>(jobService.editJob(job), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") Long id) {
		try {

			return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteJob(@PathVariable("id") Long id) {
		try {
			jobService.deleteJob(id);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
