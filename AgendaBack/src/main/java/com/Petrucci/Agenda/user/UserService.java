package com.Petrucci.Agenda.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Petrucci.Agenda.exception.NotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	public User createUser(UserPayload body) {
		User newUser = new User(body.getName(), body.getLastName(), body.getUsername(), body.getEmail(),
				body.getPassword(), Role.USER);
		return ur.save(newUser);
	}

	public User findById(UUID id) throws NotFoundException {
		return ur.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public User findByEmail(String email) {
		return ur.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovato"));
	}
}
