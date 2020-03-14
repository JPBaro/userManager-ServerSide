package com.jpbtech.webappservice.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.jpbtech.webappservice.security.service.TokenAuthenticationService;

public class JWTAuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
							throws IOException, ServletException {

		System.out.println("AUTHENTICATION FILTER-----------------------------------------------");// testing purposes JP
		System.out.println("JWTAuthenticationFilter.doFilter ");// testing purposes JP
		System.out.println("--------------------------------------------------------------------------------");// testing purposes JP
		Authentication authentication = TokenAuthenticationService
								.getAuthentication((HttpServletRequest) servletRequest);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		filterChain.doFilter(servletRequest, servletResponse);
	}

}