package com.foo.furniture;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

public class MaterialValidator extends AbstractValidator<String> {

	private static final long serialVersionUID = 1L;

	@Override
	protected void onValidate(IValidatable<String> validatable) {
		final String value = validatable.getValue();
		if ((!value.toUpperCase().equals("S"))
				&& (!value.toUpperCase().equals("P"))
				&& (!value.toUpperCase().equals("W"))) {

			error(validatable);
		}
	}

}
