package vn.nmd.sender.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.nmd.sender.enums.RequestStatus;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ADVANCE_REQUEST")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String quest;
	private Date requestDate;
	private RequestStatus requestStatus;

}
