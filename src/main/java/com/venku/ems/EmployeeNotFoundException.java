package com.venku.ems;

public class EmployeeNotFoundException extends Exception {
    private int emp_id;

    public EmployeeNotFoundException(int emp_id) {
        this.emp_id = emp_id;

    }

    public String toString() {
        return "Employee Not Found Exception"+this.emp_id;
    }
}
