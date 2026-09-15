package backend.service.impl;

import backend.repository.IDepartmentRepository;
import backend.repository.impl.DepartmentRepositoryImpl;
import backend.service.IDepartmentService;
import entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    private IDepartmentRepository repository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> getAllDepartments() {
        return repository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.getDepartmentById(id);
    }

    @Override
    public boolean themDepartment(String departmentName) {
        return repository.themDepartment(departmentName);
    }

    @Override
    public boolean xoaDepartmentTheoId(int id) {
        return repository.xoaDepartmentTheoId(id);
    }

    @Override
    public boolean suaDepartmentNameTheoId(int id, String newName) {
        return repository.suaDepartmentNameTheoId(id, newName);
    }
}