package vn.nmd.sender.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TUTORIAL_JOB")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Mapping thông tin biến với tên cột trong Database
	@Column(name = "title")
	private String title;
	// Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	private Integer approved;

}
