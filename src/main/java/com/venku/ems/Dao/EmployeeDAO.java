package com.venku.ems.Dao;

import com.venku.ems.Employee;
import com.venku.ems.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeDAO {
    public void addEmployee(Employee e);

    public abstract void deleteEmployee(int emp_id);

    public abstract void updateEmployee(Employee e);

    public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;

    public List<Employee> showAllEmployee();

    public static final String url = "jdbc:mysql://localhost:3306/ems";//need to change according to our host
    public static final String UsernName = "root";
    public static final String password = "BD@1283";
    public static final String Driver_className = "com.mysql.jdbc.Driver";
}
