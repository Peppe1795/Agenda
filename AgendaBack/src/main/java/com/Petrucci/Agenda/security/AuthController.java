package com.Petrucci.Agenda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Petrucci.Agenda.exception.UnauthorizedException;
import com.Petrucci.Agenda.user.LoginSuccesfully;
import com.Petrucci.Agenda.user.User;
import com.Petrucci.Agenda.user.UserLoginPayload;
import com.Petrucci.Agenda.user.UserPayload;
import com.Petrucci.Agenda.user.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService us;

	@Autowired
	PasswordEncoder bcrypt;

	@Autowired
	JwtTools jwtTools;

	@PostMapping("/register")
	public User registerUser(@RequestBody UserPayload body) {
		body.setPassword(bcrypt.encode(body.getPassword()));
		User user = us.createUser(body);
		return user;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginSuccesfully> login(@RequestBody UserLoginPayload body) {
		User user = null;

		if (body.getEmail() != null) {
			user = us.findByEmail(body.getEmail());
		}

		if (user != null && bcrypt.matches(body.getPassword(), user.getPassword())) {
			String token = jwtTools.creaToken(user);
			return new ResponseEntity<>(new LoginSuccesfully(token), HttpStatus.OK);
		} else {
			throw new UnauthorizedException(
					"Credenziali non valide, verifica che la password o Email ed Username siano corrette");
		}
	}
}
