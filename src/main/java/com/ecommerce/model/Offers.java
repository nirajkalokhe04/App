package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.sql.Insert;

import com.ecommerce.util.Constants;

@Entity
@Table(name="offers")
public class Offers {

	
	@Id	
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32 )
	private String id; 

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="itemId",columnDefinition = Constants.VARCHAR_16) private
	 * String itemId;
	 */
	@Column(name="itemId",columnDefinition = Constants.VARCHAR_32)
	private String itemId;
	
	@Column(name="gallerypath",columnDefinition = Constants.VARCHAR_255)
	private String galleryPath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Offers [id=" + id + ", itemId=" + itemId + ", galleryPath=" + galleryPath + "]";
	}
	
	
	
}
