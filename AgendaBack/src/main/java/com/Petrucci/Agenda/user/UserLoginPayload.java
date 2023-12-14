package com.Petrucci.Agenda.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginPayload {
	String email;
	String password;
}
