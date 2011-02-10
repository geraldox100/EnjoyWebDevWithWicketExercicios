package com.foo.diferentLanguage;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public class MultiLingualLabel extends Label{

	private static final long serialVersionUID = 1L;
	
	public MultiLingualLabel(String id) {
		super(id);
	}
	
	public MultiLingualLabel(String id, IModel<MultiLingualString> model){
		super(id, model);
	}
	
	@Override
	protected void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		replaceComponentTagBody(markupStream, openTag,getCorrectLanguageVersion((MultiLingualString) getDefaultModelObject()));
	}

	private String getCorrectLanguageVersion(
			MultiLingualString s) {
		
		if(getLocale().getLanguage().equals("zh")){
			return s.getZh();
		}
		return s.getDef();
	}

}
