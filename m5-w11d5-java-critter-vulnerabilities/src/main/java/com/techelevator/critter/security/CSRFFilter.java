package com.techelevator.critter.security;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.util.encoders.Base64;

public class CSRFFilter implements Filter {

	private static final String CSRF_TOKEN = "CSRF_TOKEN";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		if(isGET(httpRequest)) {
			handleGET(httpRequest);
		} else {
			handlePOST(httpRequest, httpResponse);
		}
		if(!response.isCommitted()) {
			chain.doFilter(httpRequest, httpResponse);
		}
	}

	private void handlePOST(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
		String sessionToken = (String)httpRequest.getSession().getAttribute(CSRF_TOKEN);
		String requestToken = (String)httpRequest.getParameter(CSRF_TOKEN);
		if(sessionToken == null || sessionToken.equals(requestToken) == false) {
			httpResponse.sendError(400);
		}
	}

	private void handleGET(HttpServletRequest httpRequest) {
		if(sessionDoesNotContainToken(httpRequest)) {
			String csrfToken = generateNewToken();
			httpRequest.getSession().setAttribute(CSRF_TOKEN, csrfToken);
		}
	}

	private boolean isGET(HttpServletRequest httpRequest) {
		return httpRequest.getMethod().equalsIgnoreCase("GET");
	}

	private String generateNewToken() {
		SecureRandom random = new SecureRandom();
		String csrfToken = new String(Base64.encode(random.generateSeed(16)));
		return csrfToken;
	}

	private boolean sessionDoesNotContainToken(HttpServletRequest httpRequest) {
		return httpRequest.getSession().getAttribute(CSRF_TOKEN) == null;
	}

	@Override
	public void destroy() {
	}

}
