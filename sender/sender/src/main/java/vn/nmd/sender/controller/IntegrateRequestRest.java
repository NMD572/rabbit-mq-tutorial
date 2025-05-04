package vn.nmd.sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.nmd.sender.dto.NotifyRequestDto;
import vn.nmd.sender.service.IIntegrateRequestService;

@RestController
@RequestMapping("/integrate-request")
public class IntegrateRequestRest {
	
	@Autowired
	private IIntegrateRequestService integrateRequestService;
	
	@PostMapping("/notify-process-finish")
	public ResponseEntity<?> sendRequest(@RequestBody NotifyRequestDto notifyRequestDto) {
		try {
			integrateRequestService.notifyProcessFinish(notifyRequestDto);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
