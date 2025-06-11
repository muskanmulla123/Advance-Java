package com.demo.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
   private int pid;
   @NotBlank(message="Product name is required")
   private String pname;
   @Min(value=1, message="quantity must be > 1")
   private int qty;
   private double price;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @NotNull(message="date is required")
   private LocalDate mfgdate;
   private String image;  //to store the filename
   private MultipartFile file; //uploading the file
public Product() {
	super();
}
public Product(int pid, String pname, int qty, double price, LocalDate mfgdate,String fname) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.qty = qty;
	this.price = price;
	this.mfgdate = mfgdate;
	this.image=fname;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public LocalDate getMfgdate() {
	return mfgdate;
}
public void setMfgdate(LocalDate mfgdate) {
	this.mfgdate = mfgdate;
}


public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", mfgdate=" + mfgdate
			+ "]";
}
   
}
