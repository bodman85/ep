package com.edp.hbm;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author ep.kiev.ua
 * @since 21 Dec 2013
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{
	private static final long serialVersionUID = 891614361127303607L;
	private int id;
	private String name;
	private String description;
	private String imageFile;
	private BigDecimal price;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "IMAGE_FILE")
	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	@Column(name = "PRICE")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(id);
		strBuff.append(", name : ").append(name);
		strBuff.append(", description : ").append(description);
		strBuff.append(", image file : ").append(imageFile);
		strBuff.append(", price : ").append(price);
		return strBuff.toString();
	}
	
	@Override
	public int hashCode() {
	    return id;
	}

	@Override
	public boolean equals(final Object obj) {
	    if (obj instanceof Product) {
	        Product item = (Product) obj;
	        return item.getId()==getId();
	    }

	    return false;
	}
}
