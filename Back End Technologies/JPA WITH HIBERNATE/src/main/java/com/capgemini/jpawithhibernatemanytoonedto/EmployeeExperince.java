package com.capgemini.jpawithhibernatemanytoonedto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.jpawithhibernateonetoonedto.EmployeeInfo;

import lombok.Data;


@Data
@Entity
@Table(name="employee_expinfo")
public class EmployeeExperince {
     @Id
     @Column
	private int expid;
    @Column
	private String companyname;
    @Column
	private int duration;

    @JoinColumn(name="eid")
    @ManyToOne(cascade = CascadeType.ALL)
private EmployeeInfo ei;
	
	
	
	
	
}
