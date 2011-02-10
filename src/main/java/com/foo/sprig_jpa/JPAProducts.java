package com.foo.sprig_jpa;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.springframework.stereotype.Repository;

import com.foo.shop.Product;

@Repository
public class JPAProducts implements Products {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Product p) {
		em.persist(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<? extends Product> extractSubRange(String keyword, SortParam sortParam,
			int first, int count) {
		
		String queryText = "select p from Product p where p.name.def like :pattern";
		if(sortParam != null){
			queryText += " order by p."+sortParam.getProperty()+" "+(sortParam.isAscending()? "asc": "desc");
		}
		
		Query q = em
				.createQuery(queryText);
		q.setParameter("pattern", "%" + keyword + "%");
		q.setFirstResult(first);
		q.setMaxResults(count);
		return q.getResultList().iterator();

	}

	@Override
	public int getMatches(String keyword) {
		Query q = em
				.createQuery("select count(*) from Product p where p.name.def like :pattern");
		q.setParameter("pattern", "%" + keyword + "%");
		return ((Number) q.getSingleResult()).intValue();

	}

}
