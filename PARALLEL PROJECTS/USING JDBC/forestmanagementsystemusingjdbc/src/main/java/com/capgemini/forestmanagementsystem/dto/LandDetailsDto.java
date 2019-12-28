package com.capgemini.forestmanagementsystem.dto;

import lombok.Data;

@Data
public class LandDetailsDto {
private int plotnumber;
private String acquireddate;
private String landvalue;
private String location;
public int getPlotnumber() {
	return plotnumber;
}
public void setPlotnumber(int plotnumber) {
	this.plotnumber = plotnumber;
}
public String getAcquireddate() {
	return acquireddate;
}
public void setAcquireddate(String acquireddate) {
	this.acquireddate = acquireddate;
}
public String getLandvalue() {
	return landvalue;
}
public void setLandvalue(String landvalue) {
	this.landvalue = landvalue;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
	



	
}
