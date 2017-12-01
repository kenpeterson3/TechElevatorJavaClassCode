package com.techelevator.critter.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.argThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.any;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.anyString;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import com.techelevator.critter.model.UserDAO;

public class AuthenticationControllerTest {

	private AuthenticationController controller;
	private UserDAO userDAO;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private HttpSession session;
	private ModelMap model;
	
	@Before
	public void setup() {
		userDAO = mock(UserDAO.class);
		controller = new AuthenticationController(userDAO);
		response = mock(HttpServletResponse.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		model = new ModelMap();
		when(request.getCookies()).thenReturn(new Cookie[]{});
	}
	
	@Test
	public void displays_login_view() {
		String viewName = controller.displayLoginForm();
		assertThat(viewName, equalTo("login"));
	}

	@Test
	public void redirects_to_user_dashboard_if_username_and_password_are_valid() {
		when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(true);
		String viewName = controller.login("myUser", "password", model);
		assertThat(viewName, equalTo("redirect:/users/myUser"));
	}
	
	@Test
	public void redirects_to_login_if_username_and_password_are_not_valid() {
		when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(false);
		String viewName = controller.login("myUser", "password", model);
		assertThat(viewName, equalTo("redirect:/login"));
	}
	
	@Test
	public void stores_username_in_cookie_after_successful_authentication() {
		when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(true);
		controller.login("myUser", "password", model);
		Cookie cookie = new Cookie("userName", "myUser");
		verify(response).addCookie(argThat(isEqualTo(cookie)));
	}

	@Test
	public void does_not_store_username_in_cookie_after_unsuccessful_authentication() {
		when(userDAO.searchForUsernameAndPassword(anyString(), anyString())).thenReturn(false);
		controller.login("myUser", "password", model);
		verify(response, never()).addCookie(any(Cookie.class));
	}
	
	@Test
	public void removes_userName_cookie_after_logout() {
		Cookie userNameCookie = spy(new Cookie("userName", "batman"));
		Cookie otherCookie = spy(new Cookie("other", "otherValue"));
		when(request.getCookies()).thenReturn(new Cookie[]{userNameCookie, otherCookie});
		controller.logout(model, session);
		verify(userNameCookie).setMaxAge(0);
		verify(response).addCookie(argThat(isEqualTo(userNameCookie)));
		verify(otherCookie, never()).setMaxAge(anyInt());
	}
	
	@Test
	public void redirects_to_home_page_after_logout() {
		String viewName = controller.logout(model, session);
		assertThat(viewName, equalTo("redirect:/"));
	}
	
	private Matcher<Cookie> isEqualTo(final Cookie expectedCookie) {
		return new TypeSafeMatcher<Cookie>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("Cookie[name:"+expectedCookie.getName()+", value:"+expectedCookie.getValue()+"]");
			}

			@Override
			protected boolean matchesSafely(Cookie cookieToTest) {
				return expectedCookie.getName().equals(cookieToTest.getName()) &&
						expectedCookie.getValue().equals(cookieToTest.getValue());
			}
		};
	}
}
