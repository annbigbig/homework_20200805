package com.kashu.website.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
//import org.hibernate.search.annotations.Analyze;
//import org.hibernate.search.annotations.Field;
//import org.hibernate.search.annotations.Index;
//import org.hibernate.search.annotations.Indexed;
//import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * https://stackoverflow.com/questions/22816817/hibernate-create-index/22829167
 * https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#_indexing
 */

@Entity
//@Indexed
@Table(name = "TB_EMPLOYEE")
//@Table(name = "TB_EMPLOYEE",indexes = {@Index(columnList = "name", name = "name_idx")})
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "name")
	//@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	@NotNull
	private String name;
	
	@Column(name = "birthday")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
    private LocalDate birthday;
	
	@Column(name = "address")
	@NotNull
	private String address;
	
	@Column(name = "luckyNumber")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	@Min(1)
	@Max(100)
	@NotNull
	private int luckyNumber;
	
	@Column(name = "status",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@NotNull
	private boolean status;
	
	public Employee() {
	}

	public Employee(int i, String n, LocalDate birthday, String address, int luckyNumber, boolean status) {
		this.id = i;
		this.name = n;
		this.birthday = birthday;
		this.address = address;
		this.luckyNumber = luckyNumber;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String str = "id = " + id + " , " + "name = " + name + " , " + "birthday = " + birthday + " , "
				+ "address = " + address + " , " + "luckyNumber = " + luckyNumber + " , "
				+ "status = " + (status ? "enabled" : "disabled");
		return str;
	}
	
}