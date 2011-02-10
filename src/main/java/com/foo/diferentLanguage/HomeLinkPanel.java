package com.foo.diferentLanguage;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class HomeLinkPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public HomeLinkPanel(String id) {
		super(id);
		add(new Link<Void>("home") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(getApplication().getHomePage());
			}

		});
	}

}
