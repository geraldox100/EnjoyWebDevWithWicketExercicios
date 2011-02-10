package com.foo.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class LinkLabel extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	public LinkLabel(String id, IModel<String> contentModel) {
		super(id, contentModel);
		AjaxLink<Void> link = new AjaxLink<Void>("link") {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				onLabelClick(target);
				
			}
		};
		add(link);
		link.add(new Label("label",getDefaultModel()));
	}

	public abstract void onLabelClick(AjaxRequestTarget target);
	
	
}
