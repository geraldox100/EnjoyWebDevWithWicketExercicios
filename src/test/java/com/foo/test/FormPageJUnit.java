package com.foo.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.ttdev.wicketpagetest.MockableSpringBeanInjector;
import com.ttdev.wicketpagetest.WebPageTestContext;
import com.ttdev.wicketpagetest.WicketSelenium;

public class FormPageJUnit {

	private DefaultSelenium selenium;
	private WicketSelenium ws;

	@Before
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

	@Test
	public void testDefaultValueDisplayed() {
		System.out.println(selenium.getValue("input").equals("abc "));
		Assert.assertEquals("abc", selenium.getValue("input"));
	}

	@Test
	public void testFormSubmission() {

		selenium.type("input", "123");
		selenium.click("//input[@type='submit']");
//		selenium.waitForPageToLoad("3000");
		ws.waitUntilAjaxDone();
		Assert.assertEquals("123123", selenium.getText("wicket=//result"));
	}

}
