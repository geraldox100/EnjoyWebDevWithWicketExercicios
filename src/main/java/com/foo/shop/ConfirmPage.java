package com.foo.shop;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

import com.foo.AuthenticatedPage;

public class ConfirmPage extends AuthenticatedPage{
	
	public ConfirmPage(){
		MySession session = ((MySession) getSession());
		
		double total = 0;
		
		for(String productId: session.getCart()){
			total += Catalog.globalCatalog.lookup(productId).getPrice();
		}
		
		User loggedInUser = session.getLoggedInUser();
//		if (loggedInUser == null) {
//			throw new RestartResponseAtInterceptPageException(LoginPage.class);
//		}

		add(new Label("total",Double.toString(total)));
		add(new Label("creditCardNo",loggedInUser.getCreditCardNo()));
		
		Form<Void> f = new Form<Void>("f");
		add(f);
		f.add(new Button("confirm"){

			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit() {
				setResponsePage(ThankYouPage.class);
			}
			
		});
		
		f.add(new Button("continueShopping"){

			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit() {
				setResponsePage(CatalogPage.class);
			}
			
		});
	}

}
