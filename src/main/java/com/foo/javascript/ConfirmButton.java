package com.foo.javascript;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.Model;

public class ConfirmButton extends Button {

	private static final long serialVersionUID = 1L;

	public ConfirmButton(String id) {
		super(id);
		add(new AttributeModifier("onclick", true, new Model<String>(
				"return myapp.confirm.getConfirmation()")));
		ResourceReference ref = new ResourceReference(ConfirmButton.class,"ConfirmButton.js");
		add(JavascriptPackageResource.getHeaderContribution(ref));

	}
}
