package com.hazelcast.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hazelcast.domain.Employee;

/**
 * 
 * @author bhawani.singh
 *
 */
public class JDBCEmployeeDAO {

	/**
	 * 
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		String query = "INSERT INTO EMPLOYEE (ID, NAME, ROLE) VALUES(?,?,?)";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/hazelcastsample", "root",
					"admin");
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getRole());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param employeeId
	 */
	public void removeEmployee(Integer employeeId) {
		String query = "DELETE FROM EMPLOYEE WHERE ID = ?";
		Employee emp = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			Connection con = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3307/hazelcastsample",
					"root", "admin");
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			Integer result = preparedStatement.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param employeeId
	 * @return
	 */
	public Employee getEmployee(final Integer employeeId) {
		String query = "SELECT ID, NAME, ROLE FROM EMPLOYEE WHERE ID = ?";
		Employee emp = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			Connection con = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3307/hazelcastsample",
					"root", "admin");
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			ResultSet rs = preparedStatement.executeQuery(query);
			while (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setName(rs.getString(3));
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	/**
	 * 
	 * @return
	 */	
	public List<Employee> listEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			Connection con = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3307/hazelcastsample",
					"root", "admin");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");

			while (rs.next()) {
				System.out.println("Testing");
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setName(rs.getString(3));
				employees.add(employee);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
}
