package vn.nmd.sender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.nmd.sender.entity.Request;
import vn.nmd.sender.enums.RequestStatus;
import vn.nmd.sender.repository.RequestRepository;
import vn.nmd.sender.service.IRequestService;

@Service
@Transactional(readOnly = true)
public class RequestServiceImpl implements IRequestService{

	@Autowired
	private RequestRepository requestRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Request sendRequest(Request request){
		requestRepository.save(request);
		return request;
	}

	@Override
	public RequestStatus getStatus(Long id) {
		return requestRepository.findById(id).orElse(new Request()).getRequestStatus();
	}

	@Override
	public Request getResult(Long id) {
		return requestRepository.findById(id).orElse(null);
	}

}
