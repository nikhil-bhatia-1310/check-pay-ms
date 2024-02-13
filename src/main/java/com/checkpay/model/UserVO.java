package com.checkpay.model;

import lombok.Data;

@Data
public class UserVO {

	private String firstName;
	private String lastName;
	private String middleName;
	private Long phoneNumber;

	private String emailId;
	private Integer pin;

}
