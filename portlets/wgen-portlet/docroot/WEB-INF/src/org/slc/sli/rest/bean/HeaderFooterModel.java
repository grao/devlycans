package org.slc.sli.rest.bean;

/**
 * HeaderFooterModel.java
 * 
 * Purpose: Liferay services are being used to fetch the header footer data, to
 * convert the header footer data to json object the header footer bean has to
 * be specified in the spring context file liferay generated header footer has
 * serializable interface so that cannot be sued in marshaling so this bean is
 * being used.
 * 
 * @author
 * @version 1.0
 */

public class HeaderFooterModel {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private long id;
	private String type;
	private String data;

}
