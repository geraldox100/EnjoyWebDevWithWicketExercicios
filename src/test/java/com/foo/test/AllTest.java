package com.foo.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ttdev.wicketpagetest.WebPageTestBasicContext;

@RunWith(Suite.class)
@SuiteClasses( { FormPageJUnit.class })
public class AllTest {
	@BeforeClass
	static public void setUp() throws Exception {
		WebPageTestBasicContext.beforePageTests();
	}

	@AfterClass
	static public void tearDown() throws Exception {
		WebPageTestBasicContext.afterPageTests();
	}
}
