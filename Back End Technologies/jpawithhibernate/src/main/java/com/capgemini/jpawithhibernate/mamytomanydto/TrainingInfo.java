package com.capgemini.jpawithhibernate.mamytomanydto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.capgemini.jpawithhibernateonetoonedto.EmployeeInfo;

import lombok.Data;

@Data
@Entity
@Table(name="traininginfo")
public class TrainingInfo {
   @Id
   @Column
	private int tid;
   @Column
   private String tname;
	
   
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name="training_infoemployee",
   joinColumns = @JoinColumn(name="tid"),
   inverseJoinColumns = @JoinColumn(name="eid"))
   private List<EmployeeInfo> elist;
   
   
	
	
}
