package com.socialbuzz.webapplication.socialweb.contactus;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactUs implements Comparable<ContactUs> {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BUSINESSNAME")
	private String businessName;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "BODY")
	private String body;

	@Column(name = "REQUESTDATE")
	private Date date;

	public ContactUs() {
	}

	public ContactUs(Integer id, String name, String businessName, String phone, String body, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.businessName = businessName;
		this.phone = phone;
		this.body = body;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", name=" + name + ", businessName=" + businessName + ", phone=" + phone
				+ ", body=" + body + ", date=" + date + "]";
	}

	@Override
	public int compareTo(ContactUs o) {
		return this.getDate().compareTo(o.getDate());
	}

}
