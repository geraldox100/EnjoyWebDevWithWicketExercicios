package com.foo.sprig_jpa;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foo.shop.Product;

@Service
@Transactional
public class DefaultProductService implements ProductService{
	
	@Autowired
	private Products products;

	
	public void add(Product p){
		products.add(p);
	}


	@Override
	public Iterator<? extends Product> extractSubRange(String keyword, SortParam sortParam,
			int first, int count) {
		return products.extractSubRange(keyword, sortParam, first, count);
	}


	@Override
	public int getMatches(String keyword) {
		return products.getMatches(keyword);
	}

}
