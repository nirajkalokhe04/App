package com.ecommerce.model;

import javax.persistence.Id;

//@Entity
public class Banner3 {

	@Id
	private String id;
	
	private String desc;
	
	private String image;
	
	private String thumb;
	
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Banner3 [id=" + id + ", desc=" + desc + ", image=" + image + ", thumb=" + thumb + ", url=" + url + "]";
	}

	
}
