package com.foo.sprig_jpa;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.foo.shop.Product;

public class ProductPage extends WebPage {

	@SpringBean
	private ProductService productService;
	private Product p;
	
	public ProductPage() {
		p = new Product();
		Form<Product> f = new Form<Product>("f",
				new CompoundPropertyModel<Product>(new PropertyModel<Product>(this,
						"p"))) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				productService.add(p);
				p = new Product();
			}

		};

		add(f);

		f.add(new TextField<String>("id"));
		f.add(new TextField<String>("name"));
	}

}
