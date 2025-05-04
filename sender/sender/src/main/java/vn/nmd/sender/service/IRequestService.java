package vn.nmd.sender.service;

import vn.nmd.sender.entity.Request;
import vn.nmd.sender.enums.RequestStatus;

public interface IRequestService {

	Request sendRequest(Request job);

	RequestStatus getStatus(Long id);
	
	Request getResult(Long id);
}
