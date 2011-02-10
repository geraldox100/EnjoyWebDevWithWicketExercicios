package com.foo.shop;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;

public class CartPage extends WebPage {
	public CartPage() {
		List<String> cart = ((MySession) getSession()).getCart();
		List<Product> products = loadProducts(cart);
		ListView<Product> eachProduct = new ListView<Product>("eachProduct",
				products) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Product> item) {
				item.setModel(new CompoundPropertyModel<Product>(item
						.getModel()));
				item.add(new Label("id"));
				item.add(new Label("name"));
				item.add(new Label("price"));
			}
		};
		add(eachProduct);
		Form<Void> f = new Form<Void>("f");
		add(f);
		f.add(new Button("checkout") {
			private static final long serialVersionUID = 1L;

			public void onSubmit() {
				setResponsePage(ConfirmPage.class);
			}
		});
		f.add(new Button("continueShopping") {
			private static final long serialVersionUID = 1L;

			public void onSubmit() {
				setResponsePage(CatalogPage.class);
			}
		});
	}

	private List<Product> loadProducts(List<String> cart) {
		List<Product> products = new ArrayList<Product>();
		for (String id : cart) {
			products.add(Catalog.globalCatalog.lookup(id));
		}
		return products;

	}

}
