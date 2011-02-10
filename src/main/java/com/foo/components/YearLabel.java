package com.foo.components;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.wicket.markup.html.basic.Label;

public class YearLabel extends Label {
	private static final long serialVersionUID = 1L;

	public YearLabel(String id) {
		super(id, Integer.toString(new GregorianCalendar().get(Calendar.YEAR)));
	}

}
