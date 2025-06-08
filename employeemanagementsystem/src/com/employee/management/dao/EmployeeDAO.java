package com.employee.management.dao;
import java.util.List;

import com.employee.management.bo.EmployeeBO;

public interface EmployeeDAO {
    void create(EmployeeBO emp);
    EmployeeBO getById(int id);
    void update(EmployeeBO emp);
    void delete(int id);
    List<EmployeeBO> getAll();
}
