package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="landdetails")
public class LandDetailsDto {
	@Id
	@Column
	private int plotNumber;
	@Column
	private String acquiredDate;
	@Column
	private String landValue;
	@Column
	private String location;
	
	
	
	public int getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}
	public String getAcquiredDate() {
		return acquiredDate;
	}
	public void setAcquiredDate(String acquiredDate) {
		this.acquiredDate = acquiredDate;
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
		return "PlotNumber : " + plotNumber + "\nAcquired Date : " + acquiredDate + "\nLand Value : "
				+ landValue + "\nLocation : " + location;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquiredDate == null) ? 0 : acquiredDate.hashCode());
		result = prime * result + ((landValue == null) ? 0 : landValue.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + plotNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LandDetailsDto other = (LandDetailsDto) obj;
		if (acquiredDate == null) {
			if (other.acquiredDate != null)
				return false;
		} else if (!acquiredDate.equals(other.acquiredDate))
			return false;
		if (landValue == null) {
			if (other.landValue != null)
				return false;
		} else if (!landValue.equals(other.landValue))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (plotNumber != other.plotNumber)
			return false;
		return true;
	}
	
	
	
	
	


}
