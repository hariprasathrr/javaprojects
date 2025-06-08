package com.employee.management.service;

import java.util.List;

import com.employee.management.bo.EmployeeBO;

public interface EmployeeService {
    void create(EmployeeBO emp);
    EmployeeBO getById(int id);
    void update(EmployeeBO emp);
    void delete(int id);
    List<EmployeeBO> getAll();
}
