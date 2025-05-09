package vn.nmd.receiver.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.nmd.sender.dto.NotifyRequestDto;

@RestController
@RequestMapping("/integrate-process-request")
public class IntegrateProcessRequestRest {
	
	@PostMapping("/handle-request")
	public ResponseEntity<?> handleRequest(@RequestBody NotifyRequestDto notifyRequestDto) {
		try {
			integrateRequestService.notifyProcessFinish(notifyRequestDto);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
