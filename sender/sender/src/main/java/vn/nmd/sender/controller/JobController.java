package vn.nmd.sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.nmd.sender.entity.Job;
import vn.nmd.sender.service.IJobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private IJobService jobService;

	@GetMapping("/send-message")
	public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
		try {
			jobService.sendMessage(message);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		try {
			return new ResponseEntity<>(jobService.createJob(job), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
