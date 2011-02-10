package com.foo.test;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class FormPage extends WebPage {

	@SpringBean
	private MyService service;
	private String input;
	private String result;
	private Label resultLabel;

	public FormPage() {
		input = service.getDefaultInput();
		Form<FormPage> form = new Form<FormPage>("form",
				new CompoundPropertyModel<FormPage>(this));
		
		add(form);
		form.add(new TextField<String>("input"));
		form.add(new AjaxButton("ok"){

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				result = service.getResult(input);
				target.addComponent(resultLabel);
				
			}
			
		});
		resultLabel = new Label("result", new PropertyModel<String>(this,"result"));
		resultLabel.setOutputMarkupId(true);
		add(resultLabel);
//		add(new Label("result", new PropertyModel<String>(this, "result")));
	}

}
