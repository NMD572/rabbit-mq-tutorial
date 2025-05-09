package vn.nmd.sender.enums;

import lombok.Getter;

@Getter
public enum RequestStatus {
	PENDING("PENDING"), PROCESSING("PROCESSING"), DONE("DONE");

	private String name;

	RequestStatus(String name) {
		this.name = name;
	}

	public static RequestStatus parseEnum(String enumName) {
		RequestStatus result = null;
		if (!"".equals(enumName)) {
			for (RequestStatus singleEnum : RequestStatus.values()) {
				if (singleEnum.getName().equals(enumName)) {
					result = singleEnum;
					break;
				}
			}
		}
		return result;
	}
}
