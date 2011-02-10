package com.foo.shop;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

public class LoginPage extends WebPage {

	private String username;
	private String password;

	public LoginPage() {

		add(new FeedbackPanel("feedback"));
		Form<LoginPage> f = new Form<LoginPage>("f",
				new CompoundPropertyModel<LoginPage>(this)) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				if (username.equals("u1") && password.equals("p1")) {
					User user = new User("u1", "u2", "111");
					((MySession) getSession()).setLoggedInUser(user);
					if (!continueToOriginalDestination()) {
						setResponsePage(CatalogPage.class);
					}
				} else {
					error("Login faild, try again");
				}
				super.onSubmit();
			}
		};

		add(f);
		f.add(new TextField<String>("username"));
		f.add(new PasswordTextField("password"));
	}

}
