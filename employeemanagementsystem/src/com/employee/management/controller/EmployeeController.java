package com.employee.management.controller;

import java.util.List;
import java.util.Scanner;

import com.employee.management.bo.EmployeeBO;
import com.employee.management.service.EmployeeService;
import com.employee.management.service.EmployeeServiceImpl;

public class EmployeeController {

    private static final EmployeeService service = new EmployeeServiceImpl();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. List All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployee();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> listEmployees();
                case 6 -> System.out.println("👋 Exiting... Goodbye!");
                default -> System.out.println("❌ Invalid choice! Please enter 1–6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addEmployee() {
        EmployeeBO emp = new EmployeeBO();

        System.out.print("First Name: ");
        emp.setFirstName(sc.nextLine());

        System.out.print("Last Name: ");
        emp.setLastName(sc.nextLine());

        System.out.print("Email: ");
        emp.setEmail(sc.nextLine());
        
        System.out.print("Phone: ");
        String phone;
        while (true) {
            phone = sc.nextLine();
            if (phone.matches("\\d+")) {
                emp.setPhone(phone);
                break;
            } else {
                System.out.print("❌ Invalid phone number! Please enter digits only: ");
            }
        }


        System.out.print("Department: ");
        emp.setDepartment(sc.nextLine());

        System.out.print("Designation: ");
        emp.setDesignation(sc.nextLine());

        System.out.print("Address: ");
        emp.setAddress(sc.nextLine());

        System.out.print("Salary: ");
        emp.setSalary(Double.parseDouble(sc.nextLine()));

        System.out.print("Status (Active/Inactive): ");
        emp.setStatus(sc.nextLine());

        service.create(emp);
        System.out.println("✅ Employee added successfully!");
    }

    private static void viewEmployee() {
        System.out.print("Enter Employee ID to view: ");
        int id = Integer.parseInt(sc.nextLine());
        EmployeeBO e = service.getById(id);

        if (e != null) {
            System.out.println("ID: " + e.getId());
            System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Phone: " + e.getPhone());
            System.out.println("Department: " + e.getDepartment());
            System.out.println("Designation: " + e.getDesignation());
            System.out.println("Address: " + e.getAddress());
            System.out.println("Salary: " + e.getSalary());
            System.out.println("Status: " + e.getStatus());
        } else {
            System.out.println("❌ Employee not found!");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        EmployeeBO e = service.getById(id);

        if (e != null) {
            System.out.println("Leave field blank to keep existing value.");

            System.out.print("First Name (" + e.getFirstName() + "): ");
            String val = sc.nextLine();
            if (!val.isEmpty()) e.setFirstName(val);

            System.out.print("Last Name (" + e.getLastName() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setLastName(val);

            System.out.print("Email (" + e.getEmail() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setEmail(val);

            while (true) {
                System.out.print("Phone (" + e.getPhone() + "): ");
                String value = sc.nextLine();
                if (value.isEmpty()) break;  // keep existing if blank
                if (value.matches("\\d+")) {
                    e.setPhone(value);
                    break;
                } else {
                    System.out.println("❌ Invalid phone number! Please enter digits only.");
                }
            }

            System.out.print("Department (" + e.getDepartment() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setDepartment(val);

            System.out.print("Designation (" + e.getDesignation() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setDesignation(val);

            System.out.print("Address (" + e.getAddress() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setAddress(val);

            System.out.print("Salary (" + e.getSalary() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setSalary(Double.parseDouble(val));

            System.out.print("Status (" + e.getStatus() + "): ");
            val = sc.nextLine();
            if (!val.isEmpty()) e.setStatus(val);

            service.update(e);
            System.out.println("✅ Employee updated successfully!");
        } else {
            System.out.println("❌ Employee not found!");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        service.delete(id);
        System.out.println("✅ Employee deleted (if existed).");
    }
    private static void listEmployees() {
        List<EmployeeBO> list = service.getAll();
        if (list.isEmpty()) {
            System.out.println("❌ No employees found.");
        } else {
            System.out.println("📋 All Employees:");
            for (EmployeeBO e : list) {
                System.out.println("ID: " + e.getId());
                System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Phone: " + e.getPhone());
                System.out.println("Department: " + e.getDepartment());
                System.out.println("Designation: " + e.getDesignation());
                System.out.println("Address: " + e.getAddress());
                System.out.println("Salary: " + e.getSalary());
                System.out.println("Status: " + e.getStatus());
                System.out.println("----------------------------");
            }
        }
    }

}
