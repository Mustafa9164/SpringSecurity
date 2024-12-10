package com.jsp.SpringPro.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.SpringPro.entity.User;

public class MapUser implements UserDetails{
	
	private String userName;
	private String password;
	private List<GrantedAuthority> roles;
	
//create constuctor 
	public MapUser(User u) {
		 userName = u.getUserName();
		 password=u.getUserPassword();                    //SimpleGrantedAuthority is a methode ref
		 roles=Arrays.stream(u.getRole().split(" ")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

}
