package com.Petrucci.Agenda.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserPayload {

	private String name;
	private String lastName;
	private String username;
	private String email;
	private String password;

}
