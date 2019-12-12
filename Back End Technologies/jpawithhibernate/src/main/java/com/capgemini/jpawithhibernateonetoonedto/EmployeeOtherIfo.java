package com.capgemini.jpawithhibernateonetoonedto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Data
@Entity
@Table(name="employee_otherinfo")
public class EmployeeOtherIfo {
    @Id
    @Column
	private int id;
   @Column
	private String pan;
    @Column
	private String fname;
   @Column
	private String mname;
	
@OneToOne(cascade = javax.persistence.CascadeType.ALL)
@JoinColumn(name="eid")
private EmployeeInfo enf;	
	
	
}
