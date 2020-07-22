package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="itemgallery")
public class ItemGallery {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id",columnDefinition = Constants.VARCHAR_32)
	private String itemGalleryId;
	
	@Column(name="item_id", columnDefinition = Constants.VARCHAR_32)
	private String itemId;
	
	@Column(name="path", columnDefinition = Constants.VARCHAR_255)
	private String galleryPath;

	public String getItemGalleryId() {
		return itemGalleryId;
	}

	public void setItemGalleryId(String itemGalleryId) {
		this.itemGalleryId = itemGalleryId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getGalleryPath() {
		return galleryPath;
	}

	public void setGalleryPath(String galleryPath) {
		this.galleryPath = galleryPath;
	}

	@Override
	public String toString() {
		return "ItemGallery [itemGalleryId=" + itemGalleryId + ", itemId=" + itemId + ", galleryPath=" + galleryPath
				+ "]";
	}
	
	
}
