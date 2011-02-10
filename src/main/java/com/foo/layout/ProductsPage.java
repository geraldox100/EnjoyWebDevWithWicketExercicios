package com.foo.layout;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Fragment;


public class ProductsPage extends BasePage {
	
	public ProductsPage() {
	}

	@Override
	Component getHeader(String id) {
		return new Fragment(id, "f1",this);
	}

}
