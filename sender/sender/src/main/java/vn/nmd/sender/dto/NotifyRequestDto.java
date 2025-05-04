package vn.nmd.sender.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.nmd.sender.enums.RequestStatus;

@Getter
@Setter
@NoArgsConstructor
public class NotifyRequestDto {
	private Long requestId;
	private RequestStatus requestStatus;
}
