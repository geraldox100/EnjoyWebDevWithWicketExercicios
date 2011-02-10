package com.foo.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.ttdev.wicketpagetest.MockableSpringBeanInjector;
import com.ttdev.wicketpagetest.WebPageTestContext;
import com.ttdev.wicketpagetest.WicketSelenium;

@Test
public class FormPageTestNG {

	private DefaultSelenium selenium;
	private WicketSelenium ws;

	@BeforeTest
	public void init() {
		MockableSpringBeanInjector.mockBean("service", new MyService() {

			@Override
			public String getResult(String input) {
				return input + input;
			}

			@Override
			public String getDefaultInput() {
				return "abc";
			}
		});
		selenium = WebPageTestContext.getSelenium();
		ws = new WicketSelenium(selenium);
		ws.openBookmarkablePage(FormPage.class);
	}

	public void testDefaultValueDisplayed() {
		assert selenium.getValue("input").equals("abc");
	}

	public void testFormSubmission() {

		assert selenium.getValue("input").equals("abc");
		selenium.type("input", "123");
		selenium.click("//input[@type='submit']");
		// selenium.waitForPageToLoad("3000");
		ws.waitUntilAjaxDone();
		assert selenium.getText("wicket=//result").equals("123123");
	}

}
