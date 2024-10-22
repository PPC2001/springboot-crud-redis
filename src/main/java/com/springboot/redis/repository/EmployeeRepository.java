package com.springboot.redis.repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.redis.model.Employee;

@Repository
public class EmployeeRepository {

	private static final String KEY = "EMPLOYEE";

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	// CREATE a Employee
	public void save(Employee employee) {
		redisTemplate.opsForHash().put(KEY, employee.getEmpId(), employee);
	}

	// READ a Employee
	public Employee findById(String empId) {
		return (Employee) redisTemplate.opsForHash().get(KEY, empId);
	}

	// READ ALL Employee
	public Map<Object, Object> findAll() {
		return redisTemplate.opsForHash().entries(KEY);
	}

	// DELETE a Employee
	public void delete(String empId) {
		redisTemplate.opsForHash().delete(KEY, empId);
	}

	// Expire employee data after 10 minutes (Optional)
	public void setExpiry(String empId, long timeout, TimeUnit unit) {
		redisTemplate.expire(empId, timeout, unit);
	}
}