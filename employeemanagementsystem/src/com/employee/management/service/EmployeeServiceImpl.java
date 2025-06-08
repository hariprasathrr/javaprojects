package com.employee.management.service;

import java.util.List;

import com.employee.management.bo.EmployeeBO;
import com.employee.management.dao.EmployeeDAO;
import com.employee.management.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO dao = new EmployeeDAOImpl();

    @Override
    public void create(EmployeeBO emp) {
        dao.create(emp);
    }

    @Override
    public EmployeeBO getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void update(EmployeeBO emp) {
        dao.update(emp);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<EmployeeBO> getAll() {
        return dao.getAll();
    }
}