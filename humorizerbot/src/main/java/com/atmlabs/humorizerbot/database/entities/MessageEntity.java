package com.atmlabs.humorizerbot.database.entities;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Message")
public class MessageEntity {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long Id;
	
	@Column(name="Message")
	@Type(type="text")
	private String Text;
	
	@Column(name="Tstamp")
	private Date Tstamp;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getTstamp() {
		return Tstamp;
	}

	public void setTstamp(Date tstamp) {
		Tstamp = tstamp;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
	
	
	
}
