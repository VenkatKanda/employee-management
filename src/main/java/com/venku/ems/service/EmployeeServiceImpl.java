package com.venku.ems.service;

import com.venku.ems.Dao.EmployeeDAO;
import com.venku.ems.Dao.EmployeeDAOMysqlImpl;
import com.venku.ems.Employee;
import com.venku.ems.EmployeeNotFoundException;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO=new  EmployeeDAOMysqlImpl();



    @Override
    public void addEmployee(Employee e) {
employeeDAO.addEmployee(e);
    }

    @Override
    public void deleteEmployee(int emp_id) {
employeeDAO.deleteEmployee(emp_id);
    }

    @Override
    public void updateEmployee(Employee e) {
employeeDAO.updateEmployee(e);
    }

    @Override
    public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
        return employeeDAO.findEmployee(e);
    }

    @Override
    public List<Employee> showAllEmployee() {
        return employeeDAO.showAllEmployee();
    }
}
