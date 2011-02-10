package com.foo.sprig_jpa;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;

import com.foo.shop.Product;

public interface Products {
	
	public void add(Product p);

	public Iterator<? extends Product> extractSubRange(String keyword, SortParam sortParam,
			int first, int count);

	public int getMatches(String keyword);

}
