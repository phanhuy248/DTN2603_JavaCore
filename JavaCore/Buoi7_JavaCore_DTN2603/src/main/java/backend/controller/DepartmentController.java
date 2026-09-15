package backend.controller;

import backend.service.IDepartmentService;
import backend.service.impl.DepartmentServiceImpl;
import entity.Department;

import java.util.List;

public class DepartmentController {
    private IDepartmentService service = new DepartmentServiceImpl();

    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    public Department getDepartmentById(int id) {
        return service.getDepartmentById(id);
    }

    public boolean themDepartment(String name) {
        return service.themDepartment(name);
    }

    public boolean xoaDepartmentTheoId(int id) {
        return service.xoaDepartmentTheoId(id);
    }

    public boolean suaDepartmentNameTheoId(int id, String newName) {
        return service.suaDepartmentNameTheoId(id, newName);
    }
}