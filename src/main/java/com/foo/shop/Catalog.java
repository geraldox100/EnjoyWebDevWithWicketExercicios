package com.foo.shop;

import java.util.ArrayList;
import java.util.List;

import com.foo.diferentLanguage.MultiLingualString;

public class Catalog {

	private List<Product> products;

	public Catalog() {
		products = new ArrayList<Product>();
		products.add(new Product("p01", new MultiLingualString("Pencil","Pencil em japones"), "a", 1.20));
		products.add(new Product("p02", new MultiLingualString("Eraser","Eraser em japones"), "b", 2.00));
		products.add(new Product("p03", new MultiLingualString("Ball pen","Ball pen em japones"), "c", 3.50));
	}

	public List<Product> getProducts() {
		return products;
	}

	public Product lookup(String id) {
		for (Product p : products) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public static Catalog globalCatalog = new Catalog();

}
