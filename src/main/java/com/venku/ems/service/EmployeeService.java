package com.venku.ems.service;

import com.venku.ems.Employee;
import com.venku.ems.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee e);

    public abstract void deleteEmployee(int emp_id);

    public abstract void updateEmployee(Employee e);

    public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;

    public List<Employee> showAllEmployee();





}
