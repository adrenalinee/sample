package com.malibu.sample.springSecurity.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.malibu.sample.springSecurity.entity.User;
import com.malibu.sample.springSecurity.entity.UserRole;
import com.malibu.sample.springSecurity.repository.UserRepository;
import com.malibu.sample.springSecurity.repository.UserRoleRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new RuntimeException("user not exist. userId: " + username);
		}
		
		List<UserRole> userRoles = userRoleRepository.findByUser(user);
		
		List<SimpleGrantedAuthority> grantedAuthorities = new LinkedList<SimpleGrantedAuthority>();
		if (userRoles != null) {
			userRoles.forEach(ur -> {
				String authority = ur.getRole().getAuthority();
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
				grantedAuthorities.add(simpleGrantedAuthority);
			});
		}
		
		return new UserDetailsImple(user, grantedAuthorities);
	}

}
