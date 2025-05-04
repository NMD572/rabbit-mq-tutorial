package vn.nmd.sender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.nmd.sender.dto.NotifyRequestDto;
import vn.nmd.sender.entity.Request;
import vn.nmd.sender.repository.RequestRepository;
import vn.nmd.sender.service.IIntegrateRequestService;


@Service
@Transactional(readOnly = true)
public class IntegrateRequestServiceImpl implements IIntegrateRequestService{

	@Autowired
	private RequestRepository requestRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void notifyProcessFinish(NotifyRequestDto notifyRequestDto) {
		if(notifyRequestDto!=null) {
			// store request into log
			
			Request requestInfor = requestRepository.findById(notifyRequestDto.getRequestId()).orElse(null);
			if(requestInfor!=null)	{
				requestInfor.setRequestStatus(notifyRequestDto.getRequestStatus());
				requestRepository.save(requestInfor);
			}
			
			// update response into log
		}
	}

}
