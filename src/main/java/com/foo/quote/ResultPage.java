package com.foo.quote;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ResultPage extends WebPage {
	public ResultPage(int stockValue) {
		add(new Label("v", Integer.toString(stockValue)));
	}
}
