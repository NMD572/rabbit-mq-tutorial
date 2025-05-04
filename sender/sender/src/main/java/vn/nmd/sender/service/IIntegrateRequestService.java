package vn.nmd.sender.service;

import vn.nmd.sender.dto.NotifyRequestDto;

public interface IIntegrateRequestService {

	void notifyProcessFinish(NotifyRequestDto notifyRequestDto);
}
