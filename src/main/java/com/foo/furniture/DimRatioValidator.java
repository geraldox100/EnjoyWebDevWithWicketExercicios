package com.foo.furniture;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.AbstractFormValidator;

public class DimRatioValidator extends AbstractFormValidator {
	
	private static final long serialVersionUID = 1L;
	private TextField<Integer> w;
	private TextField<Integer> h;

	public DimRatioValidator(TextField<Integer> w, TextField<Integer> h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public FormComponent<?>[] getDependentFormComponents() {
		return new FormComponent<?>[] { w, h };
	}

	@Override
	public void validate(Form<?> form) {
		int width = w.getConvertedInput();
		int height = h.getConvertedInput();
		if (width / height > 1.5) {
			error(w);
		}
	}

}
