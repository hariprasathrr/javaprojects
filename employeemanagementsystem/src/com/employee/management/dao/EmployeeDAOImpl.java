package com.employee.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.management.bo.EmployeeBO;
import com.employee.management.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(EmployeeBO emp) {
        String sql = "INSERT INTO employee (first_name, last_name, email, phone, department, designation, address, salary, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getPhone());
            ps.setString(5, emp.getDepartment());
            ps.setString(6, emp.getDesignation());
            ps.setString(7, emp.getAddress());
            ps.setDouble(8, emp.getSalary());
            ps.setString(9, emp.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeBO getById(int id) {
        EmployeeBO emp = null;
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection conn = DBConnectionUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = extractEmployee(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void update(EmployeeBO emp) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, email=?, phone=?, department=?, designation=?, address=?, salary=?, status=? WHERE id=?";
        try (Connection conn = DBConnectionUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getPhone());
            ps.setString(5, emp.getDepartment());
            ps.setString(6, emp.getDesignation());
            ps.setString(7, emp.getAddress());
            ps.setDouble(8, emp.getSalary());
            ps.setString(9, emp.getStatus());
            ps.setInt(10, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DBConnectionUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeBO> getAll() {
        List<EmployeeBO> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = DBConnectionUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(extractEmployee(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private EmployeeBO extractEmployee(ResultSet rs) throws SQLException {
        EmployeeBO emp = new EmployeeBO();
        emp.setId(rs.getInt("id"));
        emp.setFirstName(rs.getString("first_name"));
        emp.setLastName(rs.getString("last_name"));
        emp.setEmail(rs.getString("email"));
        emp.setPhone(rs.getString("phone"));
        emp.setDepartment(rs.getString("department"));
        emp.setDesignation(rs.getString("designation"));
        emp.setAddress(rs.getString("address"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setStatus(rs.getString("status"));
        return emp;
    }
}