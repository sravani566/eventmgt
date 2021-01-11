package com.eventapp.config;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MyAuthEntryPoint extends  BasicAuthenticationEntryPoint{

	@Override
	public void afterPropertiesSet() {
		setRealmName("Aythentication");
		super.afterPropertiesSet();
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		response.setHeader("www-Authenticate", "aurr_error"+getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter out=response.getWriter();
		out.print("401_authentication----");
		super.commence(request, response, authException);
	}

	
	
	
}
