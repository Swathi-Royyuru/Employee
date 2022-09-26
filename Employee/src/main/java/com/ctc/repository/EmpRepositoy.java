package com.ctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctc.entity.Employee;

@Repository
public interface EmpRepositoy extends JpaRepository<Employee, String> {

}
