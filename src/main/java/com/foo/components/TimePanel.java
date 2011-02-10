package com.foo.components;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TimePanel extends Panel {
	private static final long serialVersionUID = 1L;

	public TimePanel(String id) {
		super(id);
		add(new Label("hour",Integer.toString(new GregorianCalendar().get(Calendar.HOUR_OF_DAY))));
		add(new Label("minute",Integer.toString(new GregorianCalendar().get(Calendar.MINUTE))));
	}

	
	

}
