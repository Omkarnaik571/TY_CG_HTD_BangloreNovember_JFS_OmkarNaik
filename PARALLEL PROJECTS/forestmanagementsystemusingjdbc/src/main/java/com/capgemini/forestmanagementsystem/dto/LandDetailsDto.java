package com.capgemini.forestmanagementsystem.dto;

public class LandDetailsDto {
	private int plotNumber;
	private String acquireDdate;
	private String landValue;
	private String location;
	
	public int getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getAcquireDdate() {
		return acquireDdate;
	}
	public void setAcquireDdate(String acquireDdate) {
		this.acquireDdate = acquireDdate;
	}
	public String getLandValue() {
		return landValue;
	}
	public void setLandValue(String landValue) {
		this.landValue = landValue;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Plot Number : " + plotNumber + "\nAcquired Date : " + acquireDdate + "\nLand Value : "
				+ landValue + "\nLocation : " + location;
	}






}
