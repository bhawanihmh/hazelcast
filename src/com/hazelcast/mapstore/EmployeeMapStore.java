package com.hazelcast.mapstore;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hazelcast.core.MapStore;
import com.hazelcast.dao.JDBCEmployeeDAO;
import com.hazelcast.domain.Employee;
/**
 * 
 * @author bhawani.singh
 *
 */
public class EmployeeMapStore implements MapStore<Integer, Employee> {
	private JDBCEmployeeDAO employeeDAO;

	public EmployeeMapStore(JDBCEmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	public void setEmpDao(JDBCEmployeeDAO empDao) {
		this.employeeDAO = empDao;
	}

	@Override
	public void store(Integer integer, Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	public void storeAll(Map<Integer, Employee> map) {

		for (Map.Entry<Integer, Employee> mapEntry : map.entrySet()) {
			store(mapEntry.getKey(), mapEntry.getValue());
		}
	}

	@Override
	public Employee load(Integer employeeId) {
		return employeeDAO.getEmployee(employeeId);
	}

	@Override
	public Map<Integer, Employee> loadAll(Collection<Integer> collection) {
		Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		List<Employee> employees = employeeDAO.listEmployees();
		for (Employee employee : employees) {
			employeeMap.put(employee.getId(), employee);
		}
		return employeeMap;
	}

	@Override
	public Set<Integer> loadAllKeys() {
		Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		List<Employee> employees = employeeDAO.listEmployees();
		for (Employee employee : employees) {
			employeeMap.put(employee.getId(), employee);
		}
		return employeeMap.keySet();
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Collection<Integer> arg0) {
		// TODO Auto-generated method stub

	}

}
