package vn.nmd.sender.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Job {
	private Long id;
	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location ;
	
}
