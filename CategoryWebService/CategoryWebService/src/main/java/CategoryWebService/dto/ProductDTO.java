package CategoryWebService.dto;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;

public class ProductDTO {
	 private int pid;
	 private String pname;
	 private int qty;
	 private double price;
	 private String expdatestr;
	public ProductDTO() {
		super();
	}
	public ProductDTO(int pid, String pname, int qty, double price, String expdatestr) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.expdatestr = expdatestr;
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
	
	 
}
