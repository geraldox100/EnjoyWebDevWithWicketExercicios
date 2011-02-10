package com.foo.shop;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;

public class CatalogPage extends WebPage {
	public CatalogPage() {
		List<Product> products = Catalog.globalCatalog.getProducts();// new
		// ArrayList<Product>();
		ListView<Product> c = new ListView<Product>("c", products) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final ListItem<Product> item) {
				item.setModel(new CompoundPropertyModel<Product>(item
						.getModelObject()));
				item.add(new Label("id"));

				PageParameters params = new PageParameters();
				params.add("productId", item.getModel().getObject().getId());
				BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>(
						"link", DetailsPage.class, params);

				item.add(link);

				link.add(new Label("name"));
				item.add(new Label("price"));

			}
		};
		add(c);
		add(new BookmarkablePageLink<Void>("login", LoginPage.class));

		add(new Link<Void>("logout") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				getSession().invalidate();
				setResponsePage(CatalogPage.class);

			}
		});

	}

}
