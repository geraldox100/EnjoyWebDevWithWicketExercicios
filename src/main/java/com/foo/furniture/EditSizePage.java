package com.foo.furniture;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.MinimumValidator;

public class EditSizePage extends WebPage {

	public EditSizePage() {
		this(new Furniture(10, 20, "w"));
	}

	public EditSizePage(final Furniture furniture) {
		add(new FeedbackPanel("feedback"));

		Form<Furniture> f = new Form<Furniture>("f",
				new CompoundPropertyModel<Furniture>(furniture)) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {

				System.out
						.println(furniture.getWidth() + " "
								+ furniture.getHeight() + " "
								+ furniture.getMaterial());
			}
		};
		add(f);
		TextField<Integer> w = new TextField<Integer>("width");
		TextField<Integer> h = new TextField<Integer>("height");
		TextField<String> m = new TextField<String>("material");

		// w.add(new RedStarBehavior<Integer>());
		// h.add(new RedStarBehavior<Integer>());
		// m.add(new RedStarBehavior<Integer>());

		m.setRequired(true);
		m.add(new MaterialValidator());
		w.add(new MinimumValidator<Integer>(0));

		f.add(new DimRatioValidator(w, h));

		f.add(m, w, h);
		
		f.visitChildren(FormComponent.class, new IVisitor<FormComponent<?>>() {
			@Override
			public Object component(FormComponent<?> component) {
					component.add(new RedStarBehavior<Object>());
				return CONTINUE_TRAVERSAL;
			}
		});
	}
}
