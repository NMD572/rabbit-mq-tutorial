package vn.nmd.sender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.nmd.sender.repository.RequestRepository;
import vn.nmd.sender.service.IIntegrateRequestService;


@Service
@Transactional(readOnly = true)
public class IntegrateRequestServiceImpl implements IIntegrateRequestService{

	@Autowired
	private RequestRepository requestRepository;
	
//	@Override
//	@Transactional(rollbackFor = Exception.class)
//	public Request notifyProcessFinish(NotifyRequestDto notifyRequestDto) {
//		Request result = null;
//		if(notifyRequestDto!=null) {
//			// store request into log
//			
//			result = requestRepository.findById(notifyRequestDto.getId()).orElse(null);
//			if(result!=null)	{
//				RequestStatus requestStatus = RequestStatus.parseEnum(notifyRequestDto.getRequestStatus());
//				result.setRequestStatus(requestStatus);
//				requestRepository.save(result);
//			}
//			
//			// update response into log
//		}
//		return result;
//	}

}
