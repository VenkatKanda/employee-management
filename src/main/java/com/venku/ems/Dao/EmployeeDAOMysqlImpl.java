package com.venku.ems.Dao;

import com.venku.ems.Employee;
import com.venku.ems.EmployeeNotFoundException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOMysqlImpl implements EmployeeDAO {

    public static final String INS_COMMAND = "INSERT INTO employee VALUES(?,?,?,?)";
    public static final String UPDATE_COMMAND = "UPDATE employee SET emp_name=?,emp_designation=?,emp_salary=?";
    private static final String DELETE_COMMAND = "DELETE FROM employee WHERE emp_id=?";
    private static final String FIND_COMMAND = "SELECT * FROM employee WHERE emp_id=?";
    private static final String SELECT_ALL = "SELECT * FROM employee";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public EmployeeDAOMysqlImpl() {
        try {
            System.out.println("data base connection initiated");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(EmployeeDAO.url, EmployeeDAO.UsernName, EmployeeDAO.password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("unable to connect");
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee e) {
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement(INS_COMMAND);
            preparedStatement.setInt(1, e.getEmp_id());
            preparedStatement.setString(2, e.getEmp_name());
            preparedStatement.setString(3, e.getEmp_designation());
            preparedStatement.setInt(4, e.getEmp_salary());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            System.out.println("Adding record fail...unable to execute ");
            e1.printStackTrace();
        } finally {
            try {


                preparedStatement.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (i > 1) {
            System.out.println("record added");
        }
    }

    @Override
    public void deleteEmployee(int emp_id) {
        int i = 0;

        try {
            preparedStatement = connection.prepareStatement(DELETE_COMMAND);
            preparedStatement.setInt(1, emp_id);
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("unable to delete....operation failed");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (i > 0) {
                System.out.println("Successfully Deleted");
            }
        }
    }

    @Override
    public void updateEmployee(Employee e) {
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_COMMAND);
            preparedStatement.setString(1, e.getEmp_name());
            preparedStatement.setString(2, e.getEmp_designation());
            preparedStatement.setInt(3, e.getEmp_salary());
            i = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("unable to update.....");
            ex.printStackTrace();

        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (i > 0) {
                System.out.println("Record updated successfully");
            }

        }
    }

    @Override
    public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
        Employee findtemp = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_COMMAND);
            preparedStatement.setInt(1, e.getEmp_id());
            rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                throw new EmployeeNotFoundException(e.getEmp_id());
            } else
                findtemp = new Employee();
            findtemp.setEmp_name(rs.getString("emp_name"));
            findtemp.setEmp_designation(rs.getString("Designation"));
            findtemp.setEmp_id(e.getEmp_id());
        } catch (SQLException e2) {
            e2.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                rs.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            return findtemp;
        }


    }

    @Override
    public List<Employee> showAllEmployee() {
        Employee selectAllTemp = null;
        List<Employee> elist = new LinkedList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                selectAllTemp = new Employee();
                selectAllTemp.setEmp_id(rs.getInt("emp_id"));
                selectAllTemp.setEmp_designation(rs.getString("emp_designation"));
                selectAllTemp.setEmp_name(rs.getString("emp_name"));
                selectAllTemp.setEmp_salary(rs.getInt("emp_salary"));
                elist.add(selectAllTemp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return elist;
    }
}





