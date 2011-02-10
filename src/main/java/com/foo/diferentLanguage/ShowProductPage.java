package com.foo.diferentLanguage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import com.foo.shop.Product;

public class ShowProductPage extends WebPage {

	// TODO : Instalar o PropEdit seguir pagina 255
	public ShowProductPage(Product p) {
		setDefaultModel(new CompoundPropertyModel<Product>(p));

		Form<Void> form = new Form<Void>("setLocale");
		add(form);
		List<Locale> supportedLocales = new ArrayList<Locale>();
		IChoiceRenderer<Locale> choiceRenderer = new IChoiceRenderer<Locale>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(Locale locale) {

				return locale.getDisplayName();
			}

			@Override
			public String getIdValue(Locale locale, int index) {
				return Integer.toString(index);
			}
		};

		DropDownChoice<Locale> localeChoice = new DropDownChoice<Locale>(
				"selectedLocale", new PropertyModel<Locale>(getSession(),
						"locale"), supportedLocales, choiceRenderer) {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean wantOnSelectionChangedNotifications() {
				return true;
			}

			@Override
			protected void onSelectionChanged(Locale newSelection) {
			}

		};

		form.add(localeChoice);

		// add(new Image("logo"));
		add(new Label("id"));
		add(new MultiLingualLabel("name"));
		add(new HomeLinkPanel("homeLink"));

		add(new Form<Void>("f") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				setResponsePage(getApplication().getHomePage());
			}

		});
	}

}
