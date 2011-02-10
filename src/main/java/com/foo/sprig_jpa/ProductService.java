package com.foo.sprig_jpa;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import com.foo.shop.Product;

public interface ProductService {

	void add(Product p);

	int getMatches(String keyword);

	Iterator<? extends Product> extractSubRange(String keyword, SortParam sortParam, int first, int count); 
}
