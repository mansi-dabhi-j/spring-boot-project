package com.example.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	private final JwtUtil jwtUtil;
	
	public JwtInterceptor(JwtUtil jwtUtil)
	{
		this.jwtUtil=jwtUtil;
	}
	
	
	  @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        String token = request.getHeader("Authorization");
	        if (token != null && token.startsWith("Bearer ")) {
	            token = token.substring(7);
	            if (jwtUtil.validateToken(token)) {
	                return true;
	            }
	        }
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	        return false;
	    }

}
