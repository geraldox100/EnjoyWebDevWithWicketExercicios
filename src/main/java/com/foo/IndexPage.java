package com.foo;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.foo.ajax.CalcPage;
import com.foo.ajax.GradePage;
import com.foo.components.Page1;
import com.foo.diferentLanguage.AboutPage;
import com.foo.download.PhotoListingPage;
import com.foo.download.UploadPage;
import com.foo.furniture.EditSizePage;
import com.foo.furniture.QuoteInputPage;
import com.foo.javascript.ConfirmDeletePage;
import com.foo.layout.HomePage;
import com.foo.myapp.HelloPage;
import com.foo.shop.CartPage;
import com.foo.shop.CatalogPage;
import com.foo.shop.ConfirmPage;
import com.foo.shop.LoginPage;
import com.foo.shop.ThankYouPage;
import com.foo.sprig_jpa.ProductPage;
import com.foo.sprig_jpa.SearchProductsPage;
import com.foo.test.FormPage;

public class IndexPage extends WebPage {
	
	public IndexPage() {
		add(new BookmarkablePageLink<FormPage>("formPage", FormPage.class));
		//-----------------------------
		add(new BookmarkablePageLink<ConfirmDeletePage>("confirmDeletePage", ConfirmDeletePage.class));
		//-----------------------------
		add(new BookmarkablePageLink<HomePage>("homaPage", HomePage.class));
		//-----------------------------
		add(new BookmarkablePageLink<UploadPage>("uploadPage", UploadPage.class));
		add(new BookmarkablePageLink<PhotoListingPage>("photoListingPage", PhotoListingPage.class));
		//-----------------------------
		add(new BookmarkablePageLink<AboutPage>("aboutPage", AboutPage.class));
		add(new BookmarkablePageLink<SearchProductsPage>("searchProductsPage", SearchProductsPage.class));
		add(new BookmarkablePageLink<ProductPage>("productPage", ProductPage.class));
		//-----------------------------
		add(new BookmarkablePageLink<CalcPage>("calcPage", CalcPage.class));
		add(new BookmarkablePageLink<GradePage>("gradePage", GradePage.class));
		//-----------------------------
		add(new BookmarkablePageLink<Page1>("page1",Page1.class));
		//-----------------------------
		add(new BookmarkablePageLink<EditSizePage>("editSizePage",EditSizePage.class));
		add(new BookmarkablePageLink<QuoteInputPage>("quoteInputPage",QuoteInputPage.class));
		//------------------------------
		add(new BookmarkablePageLink<CartPage>("cartPage",CartPage.class));
		add(new BookmarkablePageLink<CatalogPage>("catalogPage",CatalogPage.class));
		add(new BookmarkablePageLink<ConfirmPage>("confirmPage",ConfirmPage.class));
		add(new BookmarkablePageLink<LoginPage>("loginPage",LoginPage.class));
		add(new BookmarkablePageLink<ThankYouPage>("thankYouPage",ThankYouPage.class));
		//------------------------------
		add(new BookmarkablePageLink<com.foo.quote.QuoteInputPage>("com.foo.quote.quoteInputPage",com.foo.quote.QuoteInputPage.class));
		//------------------------------       >
		add(new BookmarkablePageLink<HelloPage>("hellowPage",HelloPage.class));
	}

}
