package vn.nmd.sender.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.nmd.sender.entity.Request;
import vn.nmd.sender.service.IRequestService;

@RestController
@RequestMapping("/request")
public class RequestRest {

	@Autowired
	private IRequestService requestService;
	
	@GetMapping("/get-result/{id}")
	public ResponseEntity<?> getResult(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(requestService.getResult(id), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-status/{id}")
	public ResponseEntity<?> getStatus(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(requestService.getStatus(id), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/send-request")
	public ResponseEntity<Request> sendRequest(@RequestBody Request request) {
		try {
			return new ResponseEntity<>(requestService.sendRequest(request), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
