package com.foo.shop;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;

public class DetailsPage extends WebPage {
	
	public DetailsPage(PageParameters parameters){
		init(Catalog.globalCatalog.lookup(parameters.getString("productId")));
	}

	public DetailsPage(final Product p) {
		init(p);
	}
	
	private void init(final Product p){
		PropertyModel<String> nameModel = new PropertyModel<String>(p, "name");
		add(new Label("title", nameModel));
		add(new Label("heading", nameModel));
		add(new Label("desc", new PropertyModel<Double>(p, "desc")));

		Form<Void> f = new Form<Void>("f");
		// {
		// private static final long serialVersionUID = 1L;
		//
		// protected void onSubmit() {
		// setResponsePage(CatalogPage.class);
		// }
		// };
		add(f);

		f.add(new Button("addToCart") {
			private static final long serialVersionUID = 1L;

			public void onSubmit() {
				List<String> cart = ((MySession)getSession()).getCart();
				cart.add(p.getId());
				setResponsePage(CartPage.class);

			}
		});
		f.add(new Button("continueShopping") {
			private static final long serialVersionUID = 1L;

			public void onSubmit() {
				setResponsePage(CatalogPage.class);
			}
		});
	}
}
