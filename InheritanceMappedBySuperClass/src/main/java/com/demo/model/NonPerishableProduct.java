package com.demo.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="nonperishable")
public class NonPerishableProduct extends Product{
	private String category;

	public NonPerishableProduct() {
		super();
	}

	public NonPerishableProduct(int pid, String pname, int qty, double price, LocalDate ldt,String category) {
		super(pid,pname,qty,price,ldt);
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NonPerishableProduct [category=" + category + "]";
	}
	

}
