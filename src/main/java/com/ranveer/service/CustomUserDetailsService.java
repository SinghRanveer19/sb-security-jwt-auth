package com.ranveer.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ranveer.entity.User;
import com.ranveer.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepo;
	
	CustomUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User savedUser = userRepo.findByUsername(username).orElseThrow();
		return org.springframework.security.core.userdetails.User
				.withUsername(username)
				.password(savedUser.getPassword())
				.roles(savedUser.getRole().replace("ROLE_", ""))
				.build();
	}

}
