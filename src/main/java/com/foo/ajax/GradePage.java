package com.foo.ajax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class GradePage extends WebPage {

	private String name;
	private String gradeType = "Letter";
	private String letterGrade;
	private int integerGrade;
	private WebMarkupContainer gradeDetail;
	private DropDownChoice<String> letterGradeChoice;
	private TextField<String> integerGradeBox;

	public GradePage() {
		add(CSSPackageResource.getHeaderContribution(
				AutoCompleteTextField.class,
				"DefaultCssAutocompleteTextField.css"));

		Form<GradePage> f = new Form<GradePage>("f",
				new CompoundPropertyModel<GradePage>(this)) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				System.out.println(gradeType);
				System.out.println(gradeType.equals("Letter") ? letterGrade
						: integerGrade);
			}

		};

		add(f);

		AutoCompleteTextField<String> nameBox = new AutoCompleteTextField<String>(
				"name") {

			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<String> getChoices(String input) {
				return getNameMatches(input);
			}
		};
		
		f.add(nameBox);

		DropDownChoice<String> gradeTypeChoice = new DropDownChoice<String>(
				"gradeType", Arrays.asList("Letter", "Integger"));
		f.add(gradeTypeChoice);
		gradeTypeChoice.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				updateVisibility();
				target.addComponent(gradeDetail);
			}

		});

		gradeDetail = new WebMarkupContainer("gradeDetail");
		f.add(gradeDetail);
		gradeDetail.setOutputMarkupPlaceholderTag(true);
		letterGradeChoice = new DropDownChoice<String>("letterGrade", Arrays
				.asList("A", "B", "C", "D", "E", "F"));
		gradeDetail.add(letterGradeChoice);
		integerGradeBox = new TextField<String>("integerGrade");
		gradeDetail.add(integerGradeBox);
		updateVisibility();
	}

	private void updateVisibility() {
		letterGradeChoice.setVisible(gradeType.equals("Letter"));
		integerGradeBox.setVisible(!letterGradeChoice.isVisible());

	}

	private Iterator<String> getNameMatches(String input) {
		List<String> names = Arrays.asList("John", "Joan", "Judy", "Paul",
				"Peter");
		List<String> matches = new ArrayList<String>();
		for (String name : names) {
			if (name.startsWith(input)) {
				matches.add(name);
			}
		}
		return matches.iterator();
	}

}
