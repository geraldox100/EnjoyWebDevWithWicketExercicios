package com.foo.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class MySession extends WebSession {

	private static final long serialVersionUID = 1L;
	private List<String> cart;
	private User loggedInUser;

	public MySession(Request request) {
		super(request);
		Locale requestedLocale = this.getLocale();
		Locale supportedLocale;
		if (requestedLocale.getLanguage().equals("zh")) {
			supportedLocale = Locale.CHINESE;
		} else if (requestedLocale.getLanguage().equals("fr")) {
			supportedLocale = Locale.FRENCH;
		} else {
			supportedLocale = Locale.ENGLISH;
		}
		this.setLocale(supportedLocale);
		cart = new ArrayList<String>();
	}

	public List<String> getCart() {
		return cart;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
}