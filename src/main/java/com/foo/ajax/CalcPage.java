package com.foo.ajax;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class CalcPage extends WebPage {
	private int num;
	private int result;
	private Label r;
	private FeedbackPanel feedbackPanel;
	private MarkupContainer helpContent;

	public CalcPage() {
		Form<Void> f = new Form<Void>("f");
		
		r = new Label("r", new PropertyModel<Integer>(this, "result"));
		r.setOutputMarkupId(true);

		feedbackPanel = new FeedbackPanel("feedback");
		feedbackPanel.setOutputMarkupId(true);
		
		helpContent = new WebMarkupContainer("helpContet");
//		helpContent.setOutputMarkupId(true);
		helpContent.setVisible(false);
		helpContent.setOutputMarkupPlaceholderTag(true);
//		helpContent.setEscapeModelStrings(false);
		
//		Button help = new Button("help");
//		help.add(new AjaxEventBehavior("onclick"){
//			private static final long serialVersionUID = 1L;
//			
//
//			@Override
//			protected void onEvent(AjaxRequestTarget target) {
//				helpContent.setDefaultModel(new Model<String>("type and int, result will be displayed"));
//				target.addComponent(helpContent);
//			}
//			
//		});
		
		AjaxLink<Void> help = new AjaxLink<Void>("help") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
//				helpContent.setDefaultModel(new Model<String>("type and <b>int</b>, result will be displayed"));
				helpContent.setVisible(!helpContent.isVisible());
				target.addComponent(helpContent);	
			}
		};

		TextField<Integer> numField = new TextField<Integer>("num",
				new PropertyModel<Integer>(this, "num"));
		numField.add(new AjaxFormSubmitBehavior(f, "onkeyup") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				result = 2 * num;
				target.addComponent(r);
				target.addComponent(feedbackPanel);
			}

			@Override
			protected void onError(AjaxRequestTarget target) {
				target.addComponent(feedbackPanel);
			}

		});

		AjaxButton ok = new AjaxButton("ok") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				result = 2 * num;
				target.addComponent(r);
				target.addComponent(feedbackPanel);

			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				target.addComponent(feedbackPanel);
			}
		};

		add(helpContent);
		add(help);
		add(f);
		add(r);
		f.add(numField);
		f.add(ok);
		add(feedbackPanel);
	}

}
