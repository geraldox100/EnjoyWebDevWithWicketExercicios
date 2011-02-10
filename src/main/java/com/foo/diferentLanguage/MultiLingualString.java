package com.foo.diferentLanguage;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MultiLingualString implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String def;
	
	public MultiLingualString() {
	}
	
	public MultiLingualString(String def, String zh) {
		this.zh = zh;
		this.def = def;
	}
	private String zh;

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

}
