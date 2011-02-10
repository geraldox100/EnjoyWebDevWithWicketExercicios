package com.foo.layout;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;

public abstract class BasePage extends WebPage {
	
	public BasePage() {
		add(getHeader("header"));
	}

	abstract Component getHeader(String string);

}
