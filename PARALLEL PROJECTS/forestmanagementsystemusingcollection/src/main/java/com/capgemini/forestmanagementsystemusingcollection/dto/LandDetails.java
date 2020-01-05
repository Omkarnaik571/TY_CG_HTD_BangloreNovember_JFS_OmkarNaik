package com.capgemini.forestmanagementsystemusingcollection.dto;

public class LandDetails {
 private int plotNumber;
 private String owner;
private String acquiredDate;
private double price;
public int getPlotNumber() {
	return plotNumber;
}
public void setPlotNumber(int plotNumber) {
	this.plotNumber = plotNumber;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getAcquiredDate() {
	return acquiredDate;
}
public void setAcquiredDate(String acquiredDate) {
	this.acquiredDate = acquiredDate;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "PlotNumber : " + plotNumber + "\nOwner : " + owner + "\nAcquiredDate : " + acquiredDate + "\nPrice : "
			+ price;
}





}
