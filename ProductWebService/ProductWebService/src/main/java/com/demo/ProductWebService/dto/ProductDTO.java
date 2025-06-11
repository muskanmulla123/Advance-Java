package com.demo.ProductWebService.dto;

import java.time.LocalDate;

public class ProductDTO {
	private int pid;
	private String pname;
	private int qty;
	private double price;
	private String expdatestr;
	private int cid;
	public ProductDTO() {
		super();
	}
	public ProductDTO(int pid, String pname, int qty, double price, String expdatestr, int cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.expdatestr = expdatestr;
		this.cid = cid;
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
	public String getExpdatestr() {
		return expdatestr;
	}
	public void setExpdatestr(String expdatestr) {
		this.expdatestr = expdatestr;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "ProductDTO [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", expdatestr="
				+ expdatestr + ", cid=" + cid + "]";
	}
	
}
