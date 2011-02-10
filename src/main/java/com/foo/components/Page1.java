package com.foo.components;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.PropertyModel;

public class Page1 extends WebPage {

	private int counter = 0;
	private ModalWindow modal;

	public Page1() {
		add(new Box("box", new YearLabel(Box.CHILD_COMPONENT_ID)));
		add(new Box("box1", new TimePanel(Box.CHILD_COMPONENT_ID)));

		add(new LinkLabel("linklabel", new PropertyModel<String>(this,
				"counter")) {

			private static final long serialVersionUID = 1L;

			@Override
			public void onLabelClick(AjaxRequestTarget target) {
				counter++;
				target.addComponent(this);
			}

		}.setOutputMarkupId(true));

		// LoginPanel login = new LoginPanel("login") {
		//			
		// private static final long serialVersionUID = 1L;
		//
		// @Override
		// public void authenticate(Credential c) {
		// if(c.getUsername().equals("u1") && c.getPassword().equals("p1")){
		// setResponsePage(WelcomePage.class);
		// }else{
		// error("Login faild");
		// }
		// }
		// };
		//		
		// add(login);

		AjaxLink<Void> help = new AjaxLink<Void>("help") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				modal.show(target);
			}
		};

		add(help);
		modal = new ModalWindow("modal");
		// modal.setContent(new Label(modal.getContentId(),"some help info"));
		LoginPanel login = new LoginPanel(modal.getContentId()) {

			private static final long serialVersionUID = 1L;

			@Override
			public void authenticate(AjaxRequestTarget target, Credential c) {
				if (c.getUsername().equals("u1")
						&& c.getPassword().equals("p1")) {
					modal.close(target);
				} else {
					error("Login faild");
					target.addComponent(getFeedback());
				}
			}

		};
		modal.setContent(login);
		modal.setInitialWidth(300);
//		modal.setInitialHeight(200);
		modal.setResizable(false);
		modal.setUseInitialHeight(false);
		
		add(modal);
	}

}
