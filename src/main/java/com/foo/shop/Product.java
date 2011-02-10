package com.foo.shop;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.foo.diferentLanguage.MultiLingualString;

@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	@Id
	@GeneratedValue
	private Long entityId;
	private String id;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="def", column=@Column(name="name")),
			@AttributeOverride(name="zh", column=@Column(name="name_zh"))
	})
	private MultiLingualString name;
	
	@Column(name="descc")
	private String desc;
	private double price;
	
	public Product() {
	}
	
	public Product(String id, MultiLingualString name) {
		this.id = id;
		this.name = name;
	}

	public Product(String id, MultiLingualString name, String desc, double price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MultiLingualString getName() {
		return name;
	}

	public void setName(MultiLingualString name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}