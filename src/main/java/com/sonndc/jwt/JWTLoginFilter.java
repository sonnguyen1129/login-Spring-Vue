package com.sonndc.jwt;
import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonndc.dto.UserDto;
import com.sonndc.service.TokenAuthenticationService;
 
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	
	public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }
 
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	if (!request.getMethod().equals("POST")) {
			return null;
		}
    	UserDto userDto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        String role = userDto.getRole();
        System.out.println(role);
 
        System.out.printf("JWTLoginFilter.attemptAuthentication: username/password= %s,%s", username, password);
        System.out.println();
 
        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList()));
    }
    
//    private UserDto toUser(HttpServletRequest request) throws IOException {
//		return new ObjectMapper().readValue(request.getInputStream(), AuthUserDto.class);
//	}
 
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
 
        System.out.println("JWTLoginFilter.successfulAuthentication:");
 
        // Write Authorization to Headers of Response.
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
 
        String authorizationString = response.getHeader("Authorization");
 
        System.out.println("Authorization String=" + authorizationString);
    }
 
}