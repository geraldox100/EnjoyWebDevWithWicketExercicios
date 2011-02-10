package com.foo.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public abstract class LoginPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private Credential c;
	private FeedbackPanel feedback;

	public LoginPanel(String id) {
		super(id);
		c = new Credential();
		
		feedback = new FeedbackPanel("feedback");
		feedback.setOutputMarkupId(true);
		add(feedback);
		
		Form<Credential> f = new Form<Credential>("f",
				new CompoundPropertyModel<Credential>(c));

		add(f);
		f.add(new TextField<String>("username"));
		f.add(new PasswordTextField("password"));
		f.add(new AjaxButton("ok"){

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				authenticate(target,c);
				
			}
			
		});

	}
	public abstract void authenticate(AjaxRequestTarget target, Credential c);
	
	public FeedbackPanel getFeedback() {
		return feedback;
	}


}
