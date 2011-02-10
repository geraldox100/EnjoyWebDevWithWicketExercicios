package com.foo.javascript;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

public class ConfirmDeletePage extends WebPage{
	
	public ConfirmDeletePage() {
		Form<Void> f = new Form<Void>("f");
		f.add(new ConfirmButton("delete"));
		add(f);
	}

}
