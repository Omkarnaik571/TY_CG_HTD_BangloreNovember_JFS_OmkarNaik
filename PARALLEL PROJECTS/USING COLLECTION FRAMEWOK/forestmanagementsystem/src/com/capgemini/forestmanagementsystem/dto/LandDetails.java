package com.capgemini.forestmanagementsystem.dto;

public class LandDetails {
 private int plotnumber;
 private String owner;
private String acquireddate;
private double price;
public int getPlotnumber() {
	return plotnumber;
}
public void setPlotnumber(int plotnumber) {
	this.plotnumber = plotnumber;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getAcquireddate() {
	return acquireddate;
}
public void setAcquireddate(String acquireddate) {
	this.acquireddate = acquireddate;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Plotnumber : " + plotnumber + "\nOwner : " + owner + "\nAcquireddate : " + acquireddate + "\nPrice : "
			+ price;
}
	

	
}
