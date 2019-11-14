package com.sonndc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sonndc.dto.AuthUserDto;
import com.sonndc.entity.User;
import com.sonndc.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
//	@Autowired
//	private WebApplicationContext applicationContext;
	
	@Autowired
	private UserRepository userRepository;


//	@PostConstruct
//    public void completeSetup() {
//        userRepository = applicationContext.getBean(UserRepository.class);
//    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		
		return new AuthUserDto(user.get());
	}

}
