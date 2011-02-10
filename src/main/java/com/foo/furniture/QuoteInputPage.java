package com.foo.furniture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class QuoteInputPage extends WebPage {
	private Model<String> symModel;
	private Model<Date> dateModel;

	public QuoteInputPage() {
		FeedbackPanel feedback = new FeedbackPanel("msgs");
		add(feedback);

		Form<Void> form = new Form<Void>("f") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				String symbol = symModel.getObject();
				Date date = dateModel.getObject();

				System.out.println(symbol);
				System.out.println(date);
				ResultPage resultPage = new ResultPage((symbol + date
						.toString()).hashCode());
				setResponsePage(resultPage);
			}
		};
		symModel = new Model<String>();
		List<String> symbols = new ArrayList<String>();
		symbols.add("MSFT");
		symbols.add("IBM");
		symbols.add("RHAT");

		DropDownChoice<String> sym = new DropDownChoice<String>("sym",
				symModel, symbols);

		dateModel = new Model<Date>(new Date());

		TextField<Date> quoteDate = new TextField<Date>("quoteDate", dateModel,
				Date.class);

		sym.setRequired(true);
		quoteDate.setRequired(true);
		quoteDate.add(new DatePicker());

		form.add(quoteDate);
		form.add(sym);
		add(form);
	}

}
