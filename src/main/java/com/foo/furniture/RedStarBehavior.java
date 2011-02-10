package com.foo.furniture;

import org.apache.wicket.Component;
import org.apache.wicket.Response;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.form.FormComponent;

public class RedStarBehavior<T> extends AbstractBehavior {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public void onRendered(Component component) {
		FormComponent<T> fc = (FormComponent<T>) component;
		if (!fc.isValid()) {
			Response response = component.getResponse();
			response.write("<span style='color: red'>*</span>");
		}
	}

}
