package com.foo.sprig_jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.OddEvenItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.foo.diferentLanguage.MultiLingualLabel;
import com.foo.diferentLanguage.ShowProductPage;
import com.foo.shop.Product;

public class SearchProductsPage extends WebPage {

	@SpringBean
	private ProductService productService;

	public SearchProductsPage() {
		this("e");
	}

	@SuppressWarnings("unchecked")
	public SearchProductsPage(final String keyword) {
		ISortableDataProvider<Product> dataProvider = new SortableDataProvider<Product>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Iterator<? extends Product> iterator(int first, int count) {
				SortParam sortParam = getSort();
				return productService.extractSubRange(keyword, sortParam,
						first, count);
			}

			@Override
			public IModel<Product> model(Product object) {
				return new Model<Product>(object);
			}

			@Override
			public int size() {
				return productService.getMatches(keyword);
			}
		};

		List<IColumn<Product>> columns = new ArrayList<IColumn<Product>>();
		columns.add(new PropertyColumn<Product>(new ResourceModel("productId"), "id","id"));
		columns.add(new AbstractColumn<Product>(new ResourceModel("productName"), "name") {

			private static final long serialVersionUID = 1L;

			@Override
			public void populateItem(Item<ICellPopulator<Product>> cellItem,
					String componentId, final IModel<Product> rowModel) {
				// cellItem.add(new ProductLinkPanel(componentId, rowModel));
				Fragment productlinFragment = new Fragment(componentId, "f1",
						SearchProductsPage.this);

				cellItem.add(productlinFragment);

				Link<Void> l = new Link<Void>("l") {

					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						Product p = rowModel.getObject();
						setResponsePage(new ShowProductPage(p));
					}

				};
				productlinFragment.add(l);
				l.add(new MultiLingualLabel("label", new Model(rowModel.getObject().getName())));
			}

		});

		DefaultDataTable<Product> defaultDataTable = new DefaultDataTable<Product>(
				"defaultDataTable", columns, dataProvider, 3);
		
		DataTable<Product> dataTable = new DataTable<Product>("dataTable",
				columns.toArray(new IColumn[0]), dataProvider, 3) {

			private static final long serialVersionUID = 1L;

			@Override
			protected Item<Product> newRowItem(String id, int index,
					IModel<Product> model) {

				return new OddEvenItem<Product>(id, index, model);
			}
			
		};
		dataTable.addTopToolbar(new HeadersToolbar(dataTable, dataProvider));
		dataTable.addBottomToolbar(new NavigationToolbar(dataTable));

		add(defaultDataTable);
		add(dataTable);
	}
}