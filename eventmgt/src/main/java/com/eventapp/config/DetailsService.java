package com.eventapp.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eventapp.repo.EventUser;
import com.eventapp.service.EventUserService;

@Service
public class DetailsService implements UserDetailsService{

	@Autowired
	private EventUserService eUserService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		EventUser eUser=eUserService.findByUsername(username);
		System.out.println(eUser);
  if(eUser==null)
	  throw new UsernameNotFoundException("Not found");
  
  String[] roles=new String[eUser.getRoles().size()];
	eUser.getRoles().toArray(roles);
  
  
  User users=new User(eUser.getUsername(),eUser.getPassword(),AuthorityUtils.createAuthorityList(roles));
		return users;
	}

}

