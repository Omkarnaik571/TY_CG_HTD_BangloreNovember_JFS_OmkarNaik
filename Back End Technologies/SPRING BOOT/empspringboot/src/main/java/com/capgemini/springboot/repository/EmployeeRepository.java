package com.capgemini.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.springboot.dto.EmployeeBean;

import net.bytebuddy.asm.Advice.Return;

public interface EmployeeRepository  extends JpaRepository<EmployeeBean, Integer>{

	public EmployeeBean findByEmail(String email);
	
	@Query("from EmployeeBean where name=:key or email=:key")
	public List<EmployeeBean> findByKey(@Param("key")String key);
	
	
	
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query("update EmployeeBean set password=:password where id=:id")
	public void changePassword(@Param("id")int id,@Param("password")String password);
   	
}
