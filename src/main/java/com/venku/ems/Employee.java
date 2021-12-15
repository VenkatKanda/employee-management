package com.venku.ems;

public class Employee {
    private int emp_id;
    private String emp_name;
    private String emp_designation;
    private int emp_salary;


    public Employee(int emp_id, String emp_name, String emp_designation, int emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_designation = emp_designation;
        this.emp_salary = emp_salary;
    }

    public Employee() {

    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_designation() {
        return emp_designation;
    }

    public void setEmp_designation(String emp_designation) {
        this.emp_designation = emp_designation;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(int emp_salary) {
        this.emp_salary = emp_salary;
    }

}
