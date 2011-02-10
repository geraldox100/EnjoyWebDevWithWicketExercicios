package com.foo.components;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;

public class Box extends Panel {
	
	public static final long serialVersionUID = 1L;
	public static final String CHILD_COMPONENT_ID = "child";
	
	public Box(String id, Component c){
		super(id);
		add(c);
	}

}
