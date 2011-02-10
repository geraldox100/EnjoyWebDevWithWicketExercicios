package com.foo.myapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HelloPage extends WebPage{
	
	public HelloPage() {
		Label s = new Label("subject", "Geraldo");
		
		add(s);
	}

}
