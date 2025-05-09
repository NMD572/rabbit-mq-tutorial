package vn.nmd.sender.grpc.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.nmd.sender.service.IIntegrateRequestService;

public class RequestGrpcServiceImpl{
	
	@Autowired
	private IIntegrateRequestService integrateRequestService;
	
	// TODO: change to another service function
	
//	@Override
//	public void receiveNotificationAboutRequestStatus(NotifyRequestDto request,
//			StreamObserver<NotificationRequestResponse> responseObserver) {
//		Request result = integrateRequestService.notifyProcessFinish(request);
//		NotificationRequestResponse response = NotificationRequestResponse.newBuilder().setId(result.getId()).build();
//		responseObserver.onNext(response);
//		responseObserver.onCompleted();
//	}
}
