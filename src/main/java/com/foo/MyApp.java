package com.foo;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.foo.shop.LoginPage;
import com.foo.shop.MySession;
import com.ttdev.wicketpagetest.MockableSpringBeanInjector;

public class MyApp extends WebApplication {
	
	@Override
	public Class<? extends Page> getHomePage() {
		return IndexPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new MySession(request);
	}

	@Override
	protected void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
		getSecuritySettings().setAuthorizationStrategy(
				new SimplePageAuthorizationStrategy(AuthenticatedPage.class,
						LoginPage.class) {
					protected boolean isAuthorized() {
						return ((MySession) Session.get()).getLoggedInUser() != null;
					}
				});
		
		MockableSpringBeanInjector.installInjector(this);

	}
	
	@Override 
    public String getConfigurationType() {
		//TODO, legal pq pode colocar essa config no banco de dados e consultar a tebela de onde o sistema esta rodando
        return Application.DEPLOYMENT;
    }

}
